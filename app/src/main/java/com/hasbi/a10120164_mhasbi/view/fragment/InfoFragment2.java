package com.hasbi.a10120164_mhasbi.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.hasbi.a10120164_mhasbi.R;

public class InfoFragment2 extends Fragment { //10120164 - M Hasbi Fadilah - IF-4 - May 2023

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_info_slide2, container, false);
        return rootView;
    }
}

