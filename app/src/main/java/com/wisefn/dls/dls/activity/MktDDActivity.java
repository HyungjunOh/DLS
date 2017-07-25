package com.wisefn.dls.dls.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wisefn.dls.dls.R;
import com.wisefn.dls.dls.bean.MktDetail;
import com.wisefn.dls.dls.bean.MktDetail.MktDetailData;
import com.wisefn.dls.dls.Retrofit.MktListService;
import com.wisefn.dls.dls.Retrofit.RetroClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hyungjun on 2017-07-14.
 */

public class MktDDActivity extends AppCompatActivity{

    private TextView mktdd_title, mktdd_cmp_nm, mktdd_mem_nm, mktdd_w_nm, mktdd_v_tm, mktdd_w_detail;
    private Button mktdd_btn_check;
    private MktDetailData mktDetailData;
    private String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mktdd);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        getSupportActionBar().setTitle("상세보기");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mktdd_title = (TextView)findViewById(R.id.mktdd_title);
        mktdd_cmp_nm = (TextView)findViewById(R.id.mktdd_cmp_nm);
        mktdd_mem_nm = (TextView)findViewById(R.id.mktdd_mem_nm);
        mktdd_w_nm = (TextView)findViewById(R.id.mktdd_w_nm);
        mktdd_v_tm = (TextView)findViewById(R.id.mktdd_v_tm);
        mktdd_w_detail = (TextView)findViewById(R.id.mktdd_w_detail);
        mktdd_btn_check = (Button)findViewById(R.id.mktdd_btn_check);

        mktDetailData = new MktDetail().getMktDetailData();

        makeDetail();

        mktdd_btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void makeDetail(){
        MktListService api = RetroClient.getMktListService();

        Call<MktDetail> call = api.mListDetail(id);

        call.enqueue(new Callback<MktDetail>() {
            @Override
            public void onResponse(Call<MktDetail> call, Response<MktDetail> response) {

                if(response.isSuccessful()){
                    mktDetailData = response.body().getMktDetailData();

                    mktdd_title.setText(mktDetailData.getMktWriteTitle());
                    mktdd_cmp_nm.setText(mktDetailData.getCusCmpNM());
                    mktdd_mem_nm.setText(mktDetailData.getCusMemNM());
                    mktdd_w_nm.setText(mktDetailData.getMktWriteNM());
                    mktdd_v_tm.setText(mktDetailData.getVisitTM());
                    mktdd_w_detail.setText(mktDetailData.getMktWriteDetail());

                } else {
                    Log.e("error", "wrong error");
                }
            }

            @Override
            public void onFailure(Call<MktDetail> call, Throwable t) {
                Log.e("error", "Connection erro");
            }
        });
    }
}
