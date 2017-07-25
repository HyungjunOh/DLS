package com.wisefn.dls.dls.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hyungjun on 2017-07-13.
 */

public class RestManager {

    private MktListService mItemService;

    public MktListService getmItemService(){
        if(mItemService == null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mItemService = retrofit.create(MktListService.class);
        }

        return mItemService;
    }
}
