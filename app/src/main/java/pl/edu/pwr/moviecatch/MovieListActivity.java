package pl.edu.pwr.moviecatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import pl.edu.pwr.moviecatch.R;

import pl.edu.pwr.moviecatch.adapters.MovieRecyclerView;
import pl.edu.pwr.moviecatch.adapters.OnMovieListener;
import pl.edu.pwr.moviecatch.viewmodels.MovieListViewModel;

public class MovieListActivity extends AppCompatActivity implements OnMovieListener {

    private RecyclerView recyclerView;
    private MovieRecyclerView movieRecyclerAdapter;

    private MovieListViewModel movieListViewModel;

    boolean isPopular = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SetupSearchView();

        recyclerView = findViewById(R.id.recyclerView);
        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);

        ConfigureRecyclerView();
        ObserveAnyChange();
        ObservePopular();
        movieListViewModel.searchMoviePop(1);

        Log.v("Tagy", "ispop: " +isPopular);
    }

    private void ObservePopular(){
        movieListViewModel.getPop().observe(this, movieModels -> {
            if (movieModels != null){
                movieRecyclerAdapter.setmMovies(movieModels);
            }
        });
    }

    private void ObserveAnyChange(){
        movieListViewModel.getMovies().observe(this, movieModels -> {
            if (movieModels != null){
                movieRecyclerAdapter.setmMovies(movieModels);
            }

        });
    }

    private void ConfigureRecyclerView() {

        movieRecyclerAdapter = new MovieRecyclerView( this);
        recyclerView.setAdapter(movieRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (!recyclerView.canScrollVertically(1)){
                    movieListViewModel.searchNextpage();
                }
            }
        });
    }

    @Override
    public void onMovieClick(int position) {
        Intent intent = new Intent(this, MovieDetails.class);
        intent.putExtra("movie", movieRecyclerAdapter.getSelectedMovie(position));
        startActivity(intent);
    }

    private void SetupSearchView() {

        final SearchView searchView = findViewById(R.id.search_view);

        searchView.setOnSearchClickListener(v -> {
            isPopular = false;
            Log.v("Tagy", "ispop: " + isPopular);

        });
        searchView.setOnCloseListener(() -> false);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                movieListViewModel.searchMovieApi(
                        query,
                        1
                );
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}

