package com.wisefn.dls.dls.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wisefn.dls.dls.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyungjun on 2017-08-03.
 */

public class Opt3Adapter extends RecyclerView.Adapter<Opt3Adapter.Opt3ViewHolder> {

    private Context context;
    private ArrayList<String> arrayList;

    public Opt3Adapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public Opt3ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.op3_item, parent, false);
        Opt3ViewHolder holder = new Opt3ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(Opt3ViewHolder holder, int position) {

        holder.textView.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Opt3ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;

        public Opt3ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView10);
        }
    }
}
