package com.exemple.eternal_myproject.remote;

public class APIUtils {

    private APIUtils(){

    };

    public static  final String API_URL = "https://63610b8e67d3b7a0a6bc3240.mockapi.io/api/";

    public static UserService getUserService(){
        return RetrofitClient.getClient(API_URL).create(UserService.class);
    }

    public static LapService getLapService(){
        return RetrofitClient.getClient(API_URL).create(LapService.class);
    }
}
