package com.wisefn.dls.dls.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wisefn.dls.dls.R;
import com.wisefn.dls.dls.Utility.SoundSearcher;
import com.wisefn.dls.dls.activity.MainActivity;
import com.wisefn.dls.dls.bean.CustomerSrchList.CustomerSrchListData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyungjun on 2017-07-21.
 */

public class CSLAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    private List<CustomerSrchListData> customerSrchListDataList = null;
    private ArrayList<CustomerSrchListData> arrayList;

    public CSLAdapter(Context context, List<CustomerSrchListData> customerSrchListDataList){
        this.context = context;
        this.customerSrchListDataList = customerSrchListDataList;
        inflater = LayoutInflater.from(context);
        arrayList = MainActivity.customerSrchListDataArrayList;
    }

    public class ViewHolder{
        TextView tv_1;
        TextView tv_2;
    }

    @Override
    public int getCount() {
        return customerSrchListDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return customerSrchListDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        final CustomerSrchListData customerSrchListData = customerSrchListDataList.get(i);

        if(view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.test_name, null);
            holder.tv_1 = (TextView)view.findViewById(R.id.tv_1);
            holder.tv_2 = (TextView)view.findViewById(R.id.tv_2);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.tv_1.setText(customerSrchListData.getWATTEXT());
        holder.tv_2.setText(customerSrchListData.getCusCmpNM());

        return view;
    }

    public void fillter(String charText){

        customerSrchListDataList.clear();

        Log.e("cslAdapter : ", charText);

        if (charText.length() == 0){
            customerSrchListDataList.addAll(arrayList);
        } else {
            for (CustomerSrchListData customerSrchListData : arrayList){
                if(SoundSearcher.matchString(customerSrchListData.getWATSEARCH(), charText)){
                    customerSrchListDataList.add(customerSrchListData);
                }
            }
        }
        notifyDataSetChanged();
    }
}
