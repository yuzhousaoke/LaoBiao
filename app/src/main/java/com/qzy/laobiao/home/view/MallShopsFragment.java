package com.qzy.laobiao.home.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qzy.laobiao.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MallShopsFragment extends Fragment {

    public MallShopsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mall_shops, container, false);
    }
}
