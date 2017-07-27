package com.wisefn.dls.dls.fragment;


import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import com.wisefn.dls.dls.R;
import com.wisefn.dls.dls.Utility.ItemClickSupport;
import com.wisefn.dls.dls.bean.MktList;
import com.wisefn.dls.dls.bean.MktList.MktListData;
import com.wisefn.dls.dls.Retrofit.MktListService;
import com.wisefn.dls.dls.adapter.MktRcAdapter;
import com.wisefn.dls.dls.Retrofit.RetroClient;
import com.wisefn.dls.dls.activity.MktDDActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Option1Fragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    private ArrayList<MktListData> mktListDataArrayList;
    private RecyclerView opt_1_rcView;
    private MktRcAdapter mAdapter;
    private SwipeRefreshLayout opt_1_swipe;

    public Option1Fragment() {    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_option1, container, false);

        opt_1_rcView = (RecyclerView) view.findViewById(R.id.opt_1_rcView);
        opt_1_swipe = (SwipeRefreshLayout) view.findViewById(R.id.opt_1_swipe);

        initOp1();

        return view;
    }

    @Override
    public void onRefresh() {

        initOp1();

        opt_1_swipe.setRefreshing(false);

    }

    private void initOp1() {
        opt_1_swipe.setOnRefreshListener(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        opt_1_rcView.setLayoutManager(layoutManager);


        mktListDataArrayList = new ArrayList<>();
        mAdapter = new MktRcAdapter(getActivity());
        opt_1_rcView.setAdapter(mAdapter);

        makeList();

        ItemClickSupport.addTo(opt_1_rcView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                String mktListDetail_ID = String.valueOf(mktListDataArrayList.get(position).getMktWriteID());
                String product_NM = mktListDataArrayList.get(position).getProductNM();

                Intent intent = new Intent(getContext(), MktDDActivity.class);
                intent.putExtra("id", mktListDetail_ID);
                intent.putExtra("product", product_NM);
                startActivity(intent);
            }
        });
    }

    private void makeList() {

        MktListService api = RetroClient.getMktListService();

        Call<MktList> call = api.mList(null, "60");

        call.enqueue(new Callback<MktList>() {
            @Override
            public void onResponse(Call<MktList> call, Response<MktList> response) {

                if(response.isSuccessful()){
                    mktListDataArrayList = response.body().getData();

                    mAdapter.setMktList(mktListDataArrayList);

                } else {
                    Toast.makeText(getContext(), "worng", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MktList> call, Throwable t) {
                Toast.makeText(getContext(), "connection error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
