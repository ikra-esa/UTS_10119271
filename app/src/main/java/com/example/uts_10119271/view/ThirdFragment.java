package com.example.uts_10119271.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uts_10119271.R;
import com.example.uts_10119271.adapter.CustomPagerAdapter;

public class ThirdFragment extends Fragment {

    //    NIM : 10119271
    //    Nama : Ikra Esa A'raaf Mahardika
    //    Kelas : IF 7

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_third, container, false);
        ViewPager viewPager = (ViewPager) root.findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(getContext()));
        return root;
    }
}