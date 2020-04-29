package com.example.ghiblirepertory;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GhibliApi {
    @GET("/Luzarios/Ghibli_Repertory/master/Ghibli_Api.json")
    Call<RestGhibliResponse> getGhibliResponse();
}
