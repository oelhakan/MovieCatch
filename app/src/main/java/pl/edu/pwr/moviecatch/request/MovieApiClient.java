package pl.edu.pwr.moviecatch.request;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import pl.edu.pwr.moviecatch.AppExecutors;
import pl.edu.pwr.moviecatch.models.MovieModel;
import pl.edu.pwr.moviecatch.response.MovieSearchResponse;
import pl.edu.pwr.moviecatch.utils.Credentials;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;

public class MovieApiClient {

    public MutableLiveData<List<MovieModel>> mMovies;
    public MutableLiveData<List<MovieModel>> mMoviesPop;
    private static MovieApiClient instance;

    private RetrieveMoviesRunnable retrieveMoviesRunnable;
    private RetrieveMoviesRunnablePop retrieveMoviesRunnablePop;

    public static MovieApiClient getInstance() {
        if (instance == null) {
            instance = new MovieApiClient();
        }
        return instance;
    }

    private MovieApiClient() {
        mMovies = new MutableLiveData<>();
        mMoviesPop = new MutableLiveData<>();
    }


    public LiveData<List<MovieModel>> getMovies() {
        return mMovies;
    }

    public LiveData<List<MovieModel>> getPop() {
        return mMoviesPop;
    }

    public void searchMoviesApi(String query, int pageNumber) {

        if (retrieveMoviesRunnable != null) {
            retrieveMoviesRunnable = null;
        }

        retrieveMoviesRunnable = new RetrieveMoviesRunnable(query, pageNumber);

        final Future<?> myHandler = AppExecutors.getInstance().networkIO().submit(retrieveMoviesRunnable);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            myHandler.cancel(true);

        }, 3000, TimeUnit.MILLISECONDS);
    }


    public void searchMoviesPop(int pageNumber) {

        if (retrieveMoviesRunnablePop != null) {
            retrieveMoviesRunnablePop = null;
        }

        retrieveMoviesRunnablePop = new RetrieveMoviesRunnablePop(pageNumber);

        final Future<?> myHandler2 = AppExecutors.getInstance().networkIO().submit(retrieveMoviesRunnablePop);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            myHandler2.cancel(true);

        }, 1000, TimeUnit.MILLISECONDS);
    }

    private class RetrieveMoviesRunnable implements Runnable {

        private final String query;
        private final int pageNumber;
        boolean cancelRequest;

        public RetrieveMoviesRunnable(String query, int pageNumber) {
            this.query = query;
            this.pageNumber = pageNumber;
            cancelRequest = false;
        }

        @Override
        public void run() {

            try {

                Response<MovieSearchResponse> response = getMovies(query, pageNumber).execute();

                if (cancelRequest) {

                    return;
                }

                if (response.code() == 200) {
                    assert response.body() != null;
                    List<MovieModel> list = new ArrayList<>(((MovieSearchResponse) response.body()).getMovies());
                    if (pageNumber == 1) {
                        // Sending data to live data
                        // PostValue: used for background thread
                        // setValue: not for background thread
                        mMovies.postValue(list);

                    } else {
                        List<MovieModel> currentMovies = mMovies.getValue();
                        assert currentMovies != null;
                        currentMovies.addAll(list);
                        mMovies.postValue(currentMovies);
                    }
                } else {
                    assert response.errorBody() != null;
                    String error = response.errorBody().string();
                    Log.v("Tagy", "Error " + error);
                    mMovies.postValue(null);
                }
            } catch (IOException e) {
                e.printStackTrace();
                mMovies.postValue(null);
            }
        }

        private Call<MovieSearchResponse> getMovies(String query, int pageNumber) {
            return Servicey.getMovieApi().searchMovie(
                    Credentials.API_KEY,
                    query,
                    pageNumber
            );
        }
    }

    private class RetrieveMoviesRunnablePop implements Runnable {

        private final int pageNumber;
        boolean cancelRequest;

        public RetrieveMoviesRunnablePop(int pageNumber) {
            this.pageNumber = pageNumber;
            cancelRequest = false;
        }

        @Override
        public void run() {

            try {

                Response<MovieSearchResponse> response2 = getPop(pageNumber).execute();

                if (cancelRequest) {

                    return;
                }
                if (response2.code() == 200) {
                    assert response2.body() != null;
                    List<MovieModel> list = new ArrayList<>(((MovieSearchResponse) response2.body()).getMovies());
                    if (pageNumber == 1) {
                        mMoviesPop.postValue(list);
                    } else {
                        List<MovieModel> currentMovies = mMoviesPop.getValue();
                        assert currentMovies != null;
                        currentMovies.addAll(list);
                        mMoviesPop.postValue(currentMovies);
                    }
                } else {
                    assert response2.errorBody() != null;
                    String error = response2.errorBody().string();
                    Log.v("Tagy", "Erroryy " + error);
                    mMoviesPop.postValue(null);
                }
            } catch (IOException e) {
                e.printStackTrace();
                mMoviesPop.postValue(null);
            }
        }

        private Call<MovieSearchResponse> getPop(int pageNumber) {
            return Servicey.getMovieApi().getPopular(
                    Credentials.API_KEY,
                    pageNumber
            );
        }
    }
}
