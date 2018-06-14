package com.example.vishnusmurali.caller.fragments;


import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vishnusmurali.caller.R;
import com.example.vishnusmurali.caller.adapters.CallsRvAdapter;
import com.example.vishnusmurali.caller.models.ModelCalls;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Vishnu S Murali on 13-06-2018.
 */

public class FragmentCalls extends Fragment {
    private RecyclerView recyclerview;
    private View v;
    public FragmentCalls(){
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.frag_calls,container,false);
        recyclerview =v.findViewById(R.id.rv_calls);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager=linearLayoutManager;
        recyclerview.setLayoutManager(layoutManager);
        CallsRvAdapter adapter=new CallsRvAdapter(getContext(),getCallLogs());
        recyclerview.setAdapter(adapter);


        return v;
    }
    private List<ModelCalls>getCallLogs(){
        List<ModelCalls>list=new ArrayList<>();
        if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_CALL_LOG)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.READ_CALL_LOG},1);
        }
        Cursor cursor =getContext().getContentResolver().query(CallLog.Calls.CONTENT_URI,null,null ,null,
                CallLog.Calls.DATE );

        int number=cursor.getColumnIndex(CallLog.Calls.NUMBER);
        int duration =cursor.getColumnIndex(CallLog.Calls.DURATION);
        int date=cursor.getColumnIndex(CallLog.Calls.DATE);
        cursor.moveToFirst();
        while (cursor.moveToNext()){

            Date date1 = new Date(Long.valueOf(cursor.getString(date)));
            String mnth_date,week_day,month;
            mnth_date= (String)DateFormat.format("dd",date);
            week_day= (String)DateFormat.format("EE",date);
            month=(String) DateFormat.format("YYYY",date);
            list.add(new ModelCalls(cursor.getString(number),cursor.getString(duration),week_day+"/"+mnth_date+"/"+month));
        }
        return list;
    }
}
