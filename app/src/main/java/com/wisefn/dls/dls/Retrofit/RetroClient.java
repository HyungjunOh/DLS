package com.wisefn.dls.dls.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hyungjun on 2017-07-13.
 */

public class RetroClient {

    private static final String BASE_URL = "http://testdlsapi.wisefn.com";

    private static Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static MktListService getMktListService(){
        return getRetrofitInstance().create(MktListService.class);
    }


}
