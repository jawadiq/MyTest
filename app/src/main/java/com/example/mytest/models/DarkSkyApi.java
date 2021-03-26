package com.example.mytest.models;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DarkSkyApi {
    Call<List<Currently>> getCurrently();

}
