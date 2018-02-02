package io.github.controlwear.joystickdemo;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
import retrofit2.http.Body;

/**
 * Created by ivan on 2/1/18.
 */

public class RCCarService {

    private static String BASE_URL = "http://192.168.1.85:5000";

    public interface RCCarAPI {
        @POST("drive")
        Call<DriveResponse> drive(@Body Drive drive);
    }

    public RCCarAPI getAPI() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(RCCarAPI.class);
    }
}
