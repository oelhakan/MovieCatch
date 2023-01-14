package pl.edu.pwr.moviecatch.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import pl.edu.pwr.moviecatch.models.MovieModel;

public class MovieResponse {

    @SerializedName("results")
    @Expose
    private MovieModel movie;

    public MovieModel getMovie() {
        return movie;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movie=" + movie +
                '}';
    }
}
