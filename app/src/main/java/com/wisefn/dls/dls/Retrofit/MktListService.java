package com.wisefn.dls.dls.Retrofit;

import com.wisefn.dls.dls.bean.CustomerList;
import com.wisefn.dls.dls.bean.CustomerSrchList;
import com.wisefn.dls.dls.bean.InsertMkt;
import com.wisefn.dls.dls.bean.LoginList;
import com.wisefn.dls.dls.bean.MktDetail;
import com.wisefn.dls.dls.bean.MktList;
import com.wisefn.dls.dls.bean.ProductList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hyungjun on 2017-07-13.
 */

public interface MktListService {

    @GET("/Common/GET_MARKETING_LIST")
    Call<MktList> mList(@Query("Visit_TM_STD") String visit_tm_std, @Query("TopCnt") String topCnt);

    @GET("/Common/GET_MARKETING_DETAIL")
    Call<MktDetail> mListDetail(@Query("Mkt_Write_ID") String mkt_write_id);

    @GET("/Common/GET_CUSTOMER_INFO")
    Call<CustomerList> mCustomerList(@Query("SearchText") String searchText);

    @GET("/Common/APP_LOGIN")
    Call<LoginList> mLoginList(@Query("usr_id") String user_id, @Query("pwd") String password);

    @GET("/Common/PRODUCT_LIST")
    Call<ProductList> mProductList(@Query("UseYN") String yn);

    @GET("/Common/QRY_CUSTOMER")
    Call<CustomerSrchList> mCustomerSrchList(@Query("UseYN") String yn);

    @GET("/Common/MARKETING_WRITE")
    Call<InsertMkt> mMarketingWrite(@Query("title") String title, @Query("visitor") String visitor, @Query("Customer_ID") String customer_id,
                                    @Query("datetm") String visit_tm, @Query("product") String product_list, @Query("content") String mkt_write_detail);
}
