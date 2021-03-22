package com.okellomwaka.gettingstartedwithretrofit.api.service;
/*
Created by Okello Mwaka
*/

import com.okellomwaka.gettingstartedwithretrofit.api.model.GitHubRepo;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

//EndPoint
public interface GitHubClient {

    //Description of Repositories for user End point
    @GET("/users/{user}/repos?order=descending")
    Call<List<GitHubRepo>> reposForUser(
            @Path("user") String user
    );

    @GET("user/info")
    Call<UserInfo>getUserInfo();

    @PUT("user/info")
    Call<Void>updateUserInfo(
            @Body UserInfo userInfo
    );

    @DELETE("user")
    Call<ResponseBody>deleteUser();

    @GET("user")
    Call<ResponseBody>getProfilePic(
            @Url String url
    );


    //Inner Class
    class UserInfo {
    }
}
