package com.wisefn.dls.dls.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wisefn.dls.dls.R;
import com.wisefn.dls.dls.bean.MktList.MktListData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyungjun on 2017-07-13.
 */

public class MktRcAdapter extends RecyclerView.Adapter<MktRcAdapter.Holder> {

    List<MktListData> mktList;
    Context context;
    LinearLayoutManager mLinearLayoutManager;

    public MktRcAdapter(Activity context){
        mktList = new ArrayList<>();
        context = context;
    }

    public MktRcAdapter(List<MktListData> mktList) {
        this.mktList = mktList;
    }

    public void setMktList(List<MktListData> mktListDataList){
        mktList.clear();
        mktList.addAll(mktListDataList);
        this.notifyItemRangeInserted(0, mktListDataList.size()-1);
    }

    public void setLinearLayoutManager(LinearLayoutManager linearLayoutManager){
        this.mLinearLayoutManager = linearLayoutManager;
    }

    public void setRecycleView(RecyclerView mView){
        mView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(
                parent.getContext()).inflate(R.layout.list_item, parent, false);

        Holder vh = new Holder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MktRcAdapter.Holder holder, int position) {
        MktListData item = mktList.get(position);

        holder.opt_1_title.setText(item.getMktWriteTitle());
        holder.opt_1_name.setText(item.getCusMemNM());
        holder.opt_1_company.setText(item.getCusCmpNM());
        holder.opt_1_product.setText(item.getProductNM());
        holder.opt_1_s_time.setText(item.getVisitTM());
    }

    @Override
    public int getItemCount() {
        return mktList.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        public TextView opt_1_title;
        public TextView opt_1_name;
        public TextView opt_1_company;
        public TextView opt_1_product;
        public TextView opt_1_s_time;

        public Holder(View itemView) {
            super(itemView);
            opt_1_title = (TextView) itemView.findViewById(R.id.opt_1_title);
            opt_1_name = (TextView) itemView.findViewById(R.id.opt_1_name);
            opt_1_company = (TextView) itemView.findViewById(R.id.opt_1_company);
            opt_1_product = (TextView) itemView.findViewById(R.id.opt_1_product);
            opt_1_s_time = (TextView) itemView.findViewById(R.id.opt_1_s_time);

        }

    }

    public void add(MktListData data){
        mktList.add(data);
        notifyDataSetChanged();
    }

}

