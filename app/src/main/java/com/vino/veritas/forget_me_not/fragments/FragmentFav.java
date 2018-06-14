package com.example.vishnusmurali.caller.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vishnusmurali.caller.R;

/**
 * Created by Vishnu S Murali on 13-06-2018.
 */

public class FragmentFav extends Fragment {
    private View v;
    public FragmentFav(){
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.frag_fav,container,false);
        return v;
    }
}
