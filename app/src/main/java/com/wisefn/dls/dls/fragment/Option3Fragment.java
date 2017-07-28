package com.wisefn.dls.dls.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.wisefn.dls.dls.R;
import com.wisefn.dls.dls.adapter.CustomerAdapter;
import com.wisefn.dls.dls.bean.CustomerList.CustomerData;
import com.wisefn.dls.dls.bean.CustomerList;
import com.wisefn.dls.dls.Retrofit.MktListService;
import com.wisefn.dls.dls.Retrofit.RetroClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Option3Fragment extends Fragment implements View.OnClickListener{

    private ArrayList<CustomerData> customerDataArrayList;
    private RecyclerView c_recycleView;
    private CustomerAdapter mAdapter;

    private Button opt_3_button_1, opt_3_button_2, opt_3_button_3, opt_3_button_4, opt_3_button_5, opt_3_button_6;

    private ConstraintLayout opt_3_btn_layout;
    private ConstraintLayout opt_3_loading;

    private ImageButton iB_office, iB_mobile;
    private EditText c_search_editText;
    private Button c_btn_search, opt_3_hide_hutton;
    private String name;

    private boolean VISBLE_FLAG = true;
    private boolean CLICK_FLAG = true;

    public Option3Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_option3, container, false);

        opt_3_btn_layout = (ConstraintLayout) view.findViewById(R.id.opt_3_btn_layout);
        c_search_editText = (EditText) view.findViewById(R.id.c_search_editText);
        c_btn_search = (Button) view.findViewById(R.id.c_btn_search);
        c_recycleView = (RecyclerView) view.findViewById(R.id.c_recycleView);
        iB_mobile = (ImageButton) view.findViewById(R.id.cus_btn_mobile_call);
        iB_office = (ImageButton) view.findViewById(R.id.cus_btn_office_call);
        opt_3_hide_hutton = (Button) view.findViewById(R.id.opt_3_hide_hutton);
        opt_3_loading = (ConstraintLayout)view.findViewById(R.id.opt_3_loading);
        opt_3_loading.setVisibility(View.GONE);

        opt_3_button_1 = (Button) view.findViewById(R.id.opt_3_button_1);
        opt_3_button_2 = (Button) view.findViewById(R.id.opt_3_button_2);
        opt_3_button_3 = (Button) view.findViewById(R.id.opt_3_button_3);
        opt_3_button_4 = (Button) view.findViewById(R.id.opt_3_button_4);
        opt_3_button_5 = (Button) view.findViewById(R.id.opt_3_button_5);
        opt_3_button_6 = (Button) view.findViewById(R.id.opt_3_button_6);
        opt_3_button_1.setOnClickListener(this);
        opt_3_button_2.setOnClickListener(this);
        opt_3_button_3.setOnClickListener(this);
        opt_3_button_4.setOnClickListener(this);
        opt_3_button_5.setOnClickListener(this);
        opt_3_button_6.setOnClickListener(this);

        opt_3_hide_hutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(VISBLE_FLAG == true){
                    opt_3_btn_layout.setVisibility(View.GONE);
                    VISBLE_FLAG = false;
                    opt_3_hide_hutton.setText("보이기");
                }
                else{
                    opt_3_btn_layout.setVisibility(View.VISIBLE);
                    VISBLE_FLAG = true;
                    opt_3_hide_hutton.setText("숨기기");
                }

            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        c_recycleView.setLayoutManager(layoutManager);

        c_btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(CLICK_FLAG == true){

                    CLICK_FLAG = false;

                    customerDataArrayList = new ArrayList<>();

                    mAdapter = new CustomerAdapter(getActivity());
                    c_recycleView.setAdapter(mAdapter);

                    name = c_search_editText.getText().toString();

                    makeCList(name);
                }
            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {

        if(CLICK_FLAG == true){

            CLICK_FLAG = false;

            customerDataArrayList = new ArrayList<>();

            mAdapter = new CustomerAdapter(getActivity());
            c_recycleView.setAdapter(mAdapter);
            String name;
            switch (view.getId()){
                case R.id.opt_3_button_1:
                    name = "김";
                    break;
                case R.id.opt_3_button_2:
                    name = "박";
                    break;
                case R.id.opt_3_button_3:
                    name = "이";
                    break;
                case R.id.opt_3_button_4:
                    name = "정";
                    break;
                case R.id.opt_3_button_5:
                    name = "최";
                    break;
                case R.id.opt_3_button_6:
                    name = "황";
                    break;
                default :
                    name = "";
                    break;
            }
            makeCList(name);

        }

    }

    private void makeCList(String input) {

        if(VISBLE_FLAG == true){
            opt_3_btn_layout.setVisibility(View.GONE);
            VISBLE_FLAG = false;
            opt_3_hide_hutton.setText("보이기");
        }

        opt_3_loading.setVisibility(View.VISIBLE);

        String name = input;

        MktListService api = RetroClient.getMktListService();

        Call<CustomerList> call = api.mCustomerList(name);

        call.enqueue(new Callback<CustomerList>() {
            @Override
            public void onResponse(Call<CustomerList> call, Response<CustomerList> response) {

                if (response.isSuccessful()) {
                    customerDataArrayList = response.body().getCustomerData();

                    mAdapter.setCustomerDataList(customerDataArrayList);

                    CLICK_FLAG = true;

                    opt_3_loading.setVisibility(View.GONE);

                } else {
                    Toast.makeText(getContext(), "worng", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CustomerList> call, Throwable t) {
                Toast.makeText(getContext(), "connection error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
