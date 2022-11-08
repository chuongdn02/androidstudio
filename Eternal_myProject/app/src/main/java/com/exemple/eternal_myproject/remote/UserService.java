package com.exemple.eternal_myproject.remote;

import com.exemple.eternal_myproject.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @GET("Users/")
    Call<List<User>> getUsers();

    @POST("Users/")
    Call<User> addUser(@Body User user);

    @PUT("Users/{id}")
    Call<User> updateUser(@Path("id") int id, @Body User user);

    @DELETE ("Users/{id}")
    Call<User> deleteUser(@Path("id") int id);
}
