package com.wisefn.dls.dls.fragment;

import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.wisefn.dls.dls.R;
import com.wisefn.dls.dls.activity.MainActivity;


public class HomeFragment extends Fragment {

    ImageView imageView1, imageView2, imageView3, imageView4, imageView5;

  public HomeFragment() {    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        imageView1 = view.findViewById(R.id.home_img_view_1);
        imageView2 = view.findViewById(R.id.home_img_view_2);
        imageView3 = view.findViewById(R.id.home_img_view_3);
        imageView4 = view.findViewById(R.id.home_img_view_4);
        imageView5 = view.findViewById(R.id.home_img_view_main);

        setOnTouch();

        setOnClick();

        return view;
    }

    private void setOnTouch(){
        imageView1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    imageView1.setColorFilter(0xaa111111, PorterDuff.Mode.SRC_OVER);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    imageView1.setColorFilter(0x00000000, PorterDuff.Mode.SRC_OVER);
                }
                return false;
            }
        });
        imageView2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    imageView2.setColorFilter(0xaa111111, PorterDuff.Mode.SRC_OVER);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    imageView2.setColorFilter(0x00000000, PorterDuff.Mode.SRC_OVER);
                }
                return false;
            }
        });
        imageView3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    imageView3.setColorFilter(0xaa111111, PorterDuff.Mode.SRC_OVER);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    imageView3.setColorFilter(0x00000000, PorterDuff.Mode.SRC_OVER);
                }
                return false;
            }
        });
        imageView4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    imageView4.setColorFilter(0xaa111111, PorterDuff.Mode.SRC_OVER);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    imageView4.setColorFilter(0x00000000, PorterDuff.Mode.SRC_OVER);
                }
                return false;
            }
        });
        imageView5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    imageView5.setColorFilter(0xaa111111, PorterDuff.Mode.SRC_OVER);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    imageView5.setColorFilter(0x00000000, PorterDuff.Mode.SRC_OVER);
                }
                return false;
            }
        });
    }

    private void setOnClick(){
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).homeButtonClicked(R.id.nav_option_1);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).homeButtonClicked(R.id.nav_option_2);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).homeButtonClicked(R.id.nav_option_3);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).homeButtonClicked(R.id.nav_option_4);
            }
        });
    }

}
