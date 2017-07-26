package com.wisefn.dls.dls.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.wisefn.dls.dls.R;
import com.wisefn.dls.dls.bean.CustomerList.CustomerData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyungjun on 2017-07-14.
 */

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CHolder> {

    List<CustomerData> customerDataList;
    Context context;

    public CustomerAdapter(Activity context){
        customerDataList = new ArrayList<>();
        context = context;
    }

    public CustomerAdapter(List<CustomerData> customerDataList) {
        this.customerDataList = customerDataList;
    }

    public void setCustomerDataList(List<CustomerData> cDataList){
        customerDataList.clear();
        customerDataList.addAll(cDataList);
        this.notifyItemRangeInserted(0, cDataList.size());
    }

    @Override
    public CHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(
                parent.getContext()).inflate(R.layout.c_list_item, parent, false);

        CHolder vh = new CHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final CustomerAdapter.CHolder holder, int position) {
        final CustomerData item = customerDataList.get(position);

        holder.cus_Mem_NM.setText(item.getCusMemNM());
        holder.cus_Cmp_NM.setText(item.getCusCmpNM());
        holder.cus_Mem_Dept.setText(item.getCusMemDept());
        holder.cus_Mem_PN_Mobile.setText(item.getCusMemPNMobile());
        holder.cus_Mem_PN_Office.setText(item.getCusMemPNOffice());

        if(item.getCusMemPNMobile() == null || item.getCusMemPNMobile() == ""){
            holder.cus_Mem_PN_Mobile.setVisibility(View.GONE);
            holder.cus_btn_mobile_call.setVisibility(View.GONE);
            holder.cus_btn_mobile_msg.setVisibility(View.GONE);
        } else {
            holder.cus_Mem_PN_Mobile.setVisibility(View.VISIBLE);
            holder.cus_btn_mobile_call.setVisibility(View.VISIBLE);
            holder.cus_btn_mobile_msg.setVisibility(View.VISIBLE);
        }

        if(item.getCusMemPNOffice() == null || item.getCusMemPNOffice() == ""){
            holder.cus_Mem_PN_Office.setVisibility(View.GONE);
            holder.cus_btn_office_call.setVisibility(View.GONE);
            holder.cus_btn_office_msg.setVisibility(View.GONE);
        } else {
            holder.cus_Mem_PN_Office.setVisibility(View.VISIBLE);
            holder.cus_btn_office_call.setVisibility(View.VISIBLE);
            holder.cus_btn_office_msg.setVisibility(View.VISIBLE);
        }

        holder.cus_btn_mobile_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile = item.getCusMemPNMobile();

                if (mobile == null || mobile == ""){
                    Toast.makeText(view.getContext(), "null", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(view.getContext(), mobile, Toast.LENGTH_SHORT).show();
                    view.getContext().startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:"+mobile)));
                }
            }
        });
        holder.cus_btn_office_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String office = item.getCusMemPNOffice();

                if (office == null || office == ""){
                    Toast.makeText(view.getContext(), "null", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(view.getContext(), office, Toast.LENGTH_SHORT).show();
                    view.getContext().startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:"+office)));
                }
            }
        });
        holder.cus_btn_mobile_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile = item.getCusMemPNMobile();

                String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
                mobile =mobile.replaceAll(match, "");

                if (mobile == null || mobile == ""){
                    Toast.makeText(view.getContext(), "null", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(view.getContext(), mobile, Toast.LENGTH_SHORT).show();
                    view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", mobile, null)));
                }
            }
        });
        holder.cus_btn_office_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String office = item.getCusMemPNOffice();

                String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
                office =office.replaceAll(match, "");

                if (office == null || office == ""){
                    Toast.makeText(view.getContext(), "null", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(view.getContext(), office, Toast.LENGTH_SHORT).show();
                    view.getContext().startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+office)));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return customerDataList.size();
    }


    public class CHolder extends RecyclerView.ViewHolder{

        public TextView cus_Mem_NM;
        public TextView cus_Cmp_NM;
        public TextView cus_Mem_Dept;
        public TextView cus_Mem_PN_Mobile;
        public TextView cus_Mem_PN_Office;

        public ImageButton cus_btn_office_call;
        public ImageButton cus_btn_mobile_call;
        public ImageButton cus_btn_office_msg;
        public ImageButton cus_btn_mobile_msg;

        public CHolder(View itemView) {
            super(itemView);
            cus_Mem_NM = (TextView) itemView.findViewById(R.id.cus_Mem_NM);
            cus_Cmp_NM = (TextView) itemView.findViewById(R.id.cus_Cmp_NM);
            cus_Mem_Dept = (TextView) itemView.findViewById(R.id.cus_Mem_Dept);
            cus_Mem_PN_Mobile = (TextView) itemView.findViewById(R.id.cus_Mem_PN_Mobile);
            cus_Mem_PN_Office = (TextView) itemView.findViewById(R.id.cus_Mem_PN_Office);
            cus_btn_office_call = (ImageButton) itemView.findViewById(R.id.cus_btn_office_call);
            cus_btn_mobile_call = (ImageButton) itemView.findViewById(R.id.cus_btn_mobile_call);
            cus_btn_office_msg = (ImageButton) itemView.findViewById(R.id.cus_btn_office_msg);
            cus_btn_mobile_msg = (ImageButton) itemView.findViewById(R.id.cus_btn_mobile_msg);
        }

    }

    public void add(CustomerData data){
        customerDataList.add(data);
        notifyDataSetChanged();
    }

}

