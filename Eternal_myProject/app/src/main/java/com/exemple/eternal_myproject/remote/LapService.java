package com.exemple.eternal_myproject.remote;

import com.exemple.eternal_myproject.model.Lap;
import com.exemple.eternal_myproject.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface LapService {
    @GET("Laps/")
    Call<List<Lap>> getLaps();

    @POST("Laps/")
    Call<Lap> addLap(@Body Lap lap);

    @PUT("Laps/{id}")
    Call<Lap> updateLap(@Path("id") int id, @Body Lap lap);

    @DELETE("Laps/{id}")
    Call<Lap> deleteLap(@Path("id") int id);
}
