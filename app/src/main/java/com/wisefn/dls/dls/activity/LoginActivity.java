package com.wisefn.dls.dls.activity;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wisefn.dls.dls.R;
import com.wisefn.dls.dls.Retrofit.Constants;
import com.wisefn.dls.dls.bean.LoginList;
import com.wisefn.dls.dls.Retrofit.MktListService;
import com.wisefn.dls.dls.Retrofit.RetroClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.wisefn.dls.dls.activity.MainActivity.CURRENT_TAG;

public class LoginActivity extends AppCompatActivity {

    private Button btn_button;
    private String et_id, et_pw;
    private EditText lgn_editText_id, lgn_editText_pw;

    private LoginList loginList;

    private String loginCheck, loginDesc, userName;

    public static int countBackFlag;
    private final long FINISH_INTERVAL_TIME = 2000;
    private long backpressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        lgn_editText_id = (EditText) findViewById(R.id.lgn_editText_id);
        lgn_editText_pw = (EditText) findViewById(R.id.lgn_editText_pw);
        btn_button = (Button) findViewById(R.id.login_btn);

        loginList = new LoginList();


        btn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                et_id = lgn_editText_id.getText().toString();
                et_pw = lgn_editText_pw.getText().toString();

                doLogin(et_id, et_pw);

            }
        });

    }

    private void doLogin(String id, String pw){

        MktListService api = RetroClient.getMktListService();

        Call<LoginList> call = api.mLoginList(id, pw);

        call.enqueue(new Callback<LoginList>() {
            @Override
            public void onResponse(Call<LoginList> call, Response<LoginList> response) {

                if(response.isSuccessful()){
                    loginList = response.body();
                    List<LoginList.Data0> data0 = loginList.getData0();
                    loginCheck = data0.get(0).getLoginYN();
                    Log.e("logincheck", loginCheck);

                    if(loginCheck.equals("Y")){
                        Log.e("logincheck", "yes");
                        List<LoginList.Data1> data1 = loginList.getData1();
                        userName = data1.get(0).getUserName();

                        Intent intent = getIntent();
                        MainActivity.LOGINSTATE = Constants.LOGIN.LOGINSUCCESS;
                        intent.putExtra("data_id", userName);
                        intent.putExtra("login_id", et_id);
                        setResult(3917, intent);
                        finish();
                    } else {
                        Log.e("logincheck", "no");
                        loginDesc = data0.get(0).getLoginDesc();
                        Toast.makeText(getApplicationContext(), loginDesc, Toast.LENGTH_SHORT).show();
                        userName = null;
                    }

                } else {
                    android.util.Log.e("error", "wrong error");
                }
            }

            @Override
            public void onFailure(Call<LoginList> call, Throwable t) {
                android.util.Log.e("error", "Connection erro");
            }
        });
    }

    @Override
    public void onBackPressed() {

        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backpressedTime;

        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime) {
//            super.onBackPressed();
            finishAffinity();
            return;
        } else {
            backpressedTime = tempTime;
            Toast.makeText(getApplicationContext(), "한번 더 뒤로가기를 누르시면 \n 종료됩니다.", Toast.LENGTH_SHORT).show();
        }
    }


}
