package com.wisefn.dls.dls.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.wisefn.dls.dls.R;
import com.wisefn.dls.dls.bean.MktDetail;
import com.wisefn.dls.dls.bean.MktDetail.MktDetailData;
import com.wisefn.dls.dls.Retrofit.MktListService;
import com.wisefn.dls.dls.Retrofit.RetroClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hyungjun on 2017-07-14.
 */

public class MktDDActivity extends AppCompatActivity implements View.OnTouchListener{

    private TextView mktdd_title, mktdd_cmp_nm, mktdd_mem_nm, mktdd_w_nm, mktdd_v_tm, mktdd_w_detail, mktdd_product;
    private Button mktdd_btn_check, mktdd_btn_pre, mktdd_btn_post;
    private MktDetailData mktDetailData;
    private String id, product;
    private int currentIndex;
    private ArrayList<String> mkt_ID;

    private ConstraintLayout mktdd_constraintLayout;

    private float pressedX;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mktdd);

        mktdd_constraintLayout = (ConstraintLayout)findViewById(R.id.mktdd_constraintLayout);
        mktdd_constraintLayout.setOnTouchListener(this);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        product = intent.getStringExtra("product");
        mkt_ID = intent.getStringArrayListExtra("id_array");

        for(int i=0; i<mkt_ID.size(); i++){
            if(id.equals(mkt_ID.get(i))){
                currentIndex = i;
            }
        }

        Log.e("list_ID", mkt_ID.get(0));
        Log.e("list_ID", currentIndex+"");

        getSupportActionBar().setTitle("상세보기");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mktdd_title = (TextView)findViewById(R.id.mktdd_title);
        mktdd_cmp_nm = (TextView)findViewById(R.id.mktdd_cmp_nm);
        mktdd_mem_nm = (TextView)findViewById(R.id.mktdd_mem_nm);
        mktdd_w_nm = (TextView)findViewById(R.id.mktdd_w_nm);
        mktdd_v_tm = (TextView)findViewById(R.id.mktdd_v_tm);
        mktdd_w_detail = (TextView)findViewById(R.id.mktdd_w_detail);
        mktdd_btn_check = (Button)findViewById(R.id.mktdd_btn_check);
        mktdd_product = (TextView)findViewById(R.id.mktdd_product);
        mktdd_btn_pre = (Button)findViewById(R.id.mktdd_btn_pre);
        mktdd_btn_post = (Button)findViewById(R.id.mktdd_btn_post);

        mktDetailData = new MktDetail().getMktDetailData();

        makeDetail(id);

        mktdd_btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mktdd_btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentIndex == 0){
                    Toast.makeText(getApplicationContext(), "최신", Toast.LENGTH_SHORT).show();
                }else {
                    makeDetail(mkt_ID.get(--currentIndex));
                }
            }
        });

        mktdd_btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentIndex == mkt_ID.size()-1){
                    Toast.makeText(getApplicationContext(), "마지막", Toast.LENGTH_SHORT).show();
                }else {
                    makeDetail(mkt_ID.get(++currentIndex));
                }
            }
        });
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float distance = 0;

        switch(motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN:
                pressedX = motionEvent.getX();
                Log.e("getX : ", pressedX+"");
                break;

            case MotionEvent.ACTION_UP:
                distance = pressedX - motionEvent.getX();
                Log.e("getX : ", distance+"");

                if (distance > 150) {
                    // 왼쪽
                    if(currentIndex == mkt_ID.size()-1){
                        Toast.makeText(getApplicationContext(), "마지막", Toast.LENGTH_SHORT).show();
                    }else {
                        makeDetail(mkt_ID.get(++currentIndex));
                    }
                } else if(distance < -150) {
                    // 오른쪽
                    if(currentIndex == 0){
                        Toast.makeText(getApplicationContext(), "최신", Toast.LENGTH_SHORT).show();
                    }else {
                        makeDetail(mkt_ID.get(--currentIndex));
                    }
                }

                break;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void makeDetail(String index){
        MktListService api = RetroClient.getMktListService();

        Call<MktDetail> call = api.mListDetail(index);

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
                    mktdd_product.setText(product);

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
