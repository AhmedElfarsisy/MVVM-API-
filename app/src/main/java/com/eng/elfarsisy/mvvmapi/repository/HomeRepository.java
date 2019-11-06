package com.eng.elfarsisy.mvvmapi.repository;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.eng.elfarsisy.mvvmapi.api.MoviesApi;
import com.eng.elfarsisy.mvvmapi.api.RetrofitClient;
import com.eng.elfarsisy.mvvmapi.model.MovieResponse;
import com.eng.elfarsisy.mvvmapi.model.Result;
import com.eng.elfarsisy.mvvmapi.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class HomeRepository {
    private static HomeRepository instance;
    private ArrayList<Result> mMoviedata = new ArrayList<>();

    public static HomeRepository getInstance() {
        if (instance != null) {
            instance = new HomeRepository();
        }
        return instance;
    }

   public MutableLiveData<List<Result>> getHomeMovie() {
        setMovie();
        MutableLiveData<List<Result>> mMovie = new MutableLiveData<>();
        mMovie.setValue(mMoviedata);
        return mMovie;

    }

    private void setMovie() {
        Retrofit retrofit = RetrofitClient.getInstance();
        MoviesApi moviesApi = retrofit.create(MoviesApi.class);
        Call<MovieResponse> movie = moviesApi.getMoviesResponse("popular", "39124f42fcda5e6e4e22a9d602876810");
        movie.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse movieResponse = response.body();
                mMoviedata= (ArrayList<Result>) movieResponse.getResults();
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.i(TAG, "onFailure: ");            }
        });

    }

}
