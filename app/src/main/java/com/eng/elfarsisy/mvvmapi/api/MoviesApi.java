package com.eng.elfarsisy.mvvmapi.api;

import com.eng.elfarsisy.mvvmapi.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesApi {
    @GET("3/movie/{sort}")
    Call<MovieResponse> getMoviesResponse(@Path("sort") String sort, @Query("api_key") String key);
}
