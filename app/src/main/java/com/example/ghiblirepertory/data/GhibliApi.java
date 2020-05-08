package com.example.ghiblirepertory.data;

import com.example.ghiblirepertory.presentation.model.RestGhibliResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GhibliApi {
    @GET("/Luzarios/Ghibli_Repertory/master/Api.json")
    Call<RestGhibliResponse> getGhibliResponse();
}
