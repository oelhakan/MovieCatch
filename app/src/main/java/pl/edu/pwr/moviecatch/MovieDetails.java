package pl.edu.pwr.moviecatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import pl.edu.pwr.moviecatch.R;

import pl.edu.pwr.moviecatch.models.MovieModel;

public class MovieDetails extends AppCompatActivity {

    private ImageView imageViewDetails;
    private TextView titleDetails, descDetails;
    private RatingBar ratingBarDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        imageViewDetails = findViewById(R.id.imageView_details);
        titleDetails = findViewById(R.id.textView_title_details);
        descDetails = findViewById(R.id.textView_desc_details);
        ratingBarDetails = findViewById(R.id.ratingBar_details);
        GetDataFromIntent();
    }

    private void GetDataFromIntent() {
        if (getIntent().hasExtra("movie")){
            MovieModel movieModel = getIntent().getParcelableExtra("movie");

            titleDetails.setText(movieModel.getTitle());
            descDetails.setText(movieModel.getMovie_overview());
            ratingBarDetails.setRating((movieModel.getVote_average())/2);

            Log.v("Tagy" ,"X"+ movieModel.getMovie_overview());

            Glide.with(this)
                    .load("https://image.tmdb.org/t/p/w500/"
                    +movieModel.getPoster_path())
                    .into(imageViewDetails);
        }
    }

    public static Intent getIntent(Context context, MovieModel movieModel) {
        Intent intent = new Intent(context, MovieDetails.class);
        intent.putExtra("movie", movieModel);
        return intent;
    }

}