package com.example.driver;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {

    @FormUrlEncoded
    @POST("user/login")
    Call<ResponseBody> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("offers")
    Call<ResponseBody> listOffers(@Header("Authorization") String token);

    @PATCH("user/refresh")
    Call<ResponseBody> refreshToken(@Header("Authorization") String token);

    @PUT("offers/receive")
    Call<ResponseBody> putReceiveOffer(
            @Header("Authorization") String token,
            @Body Map<String, Integer> map
    );

    @PUT("offers/{id}/{decision}")
    Call<ResponseBody> offerDecision(
            @Header("Authorization") String token,
            @Path("id") int offer_id,
            @Path("decision") String decision
    );

    //Rest go here
    @POST("lessons")
    Call<ResponseBody> createLesson(
            @Header("Authorization") String token,
            @Body HashMap<String, Object> map
    );

    //Rest go there
    @GET("learners")
    Call<ResponseBody> learnersList(@Header("Authorization") String token);

    @GET("learners/{id}")
    Call<ResponseBody> learnerDetails(
            @Header("Authorization") String token,
            @Path("id") int id
    );

    @GET("payments")
    Call<ResponseBody> paymentList(@Header("Authorization") String token);
}
