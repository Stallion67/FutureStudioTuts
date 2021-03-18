package com.okellomwaka.gettingstartedwithretrofit;
/*
Created by Okello Mwaka
*/

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

//EndPoint
public interface GitHubClient {

    //Description of Repositories for user End point
    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(
            @Path("user") String user
    );
}
