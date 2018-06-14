package com.example.vishnusmurali.caller.fragments;



import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vishnusmurali.caller.R;
import com.example.vishnusmurali.caller.adapters.ContactsRvAdapter;
import com.example.vishnusmurali.caller.models.ModelContacts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vishnu S Murali on 13-06-2018.
 */

public class FragmentContacts extends Fragment {
    private View v;
    private RecyclerView recyclerView;

    public FragmentContacts() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frag_contacts, container, false);
        recyclerView = v.findViewById(R.id.rv_contacts);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager = linearLayoutManager;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(layoutManager);
        ContactsRvAdapter adapter=new ContactsRvAdapter(getContext(),getContacts());
        recyclerView.setAdapter(adapter);
        return v;
    }

    private List<ModelContacts> getContacts() {
        List<ModelContacts> list = new ArrayList<>();
        Cursor cursor = getContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                null, null, ContactsContract.Contacts.DISPLAY_NAME + " ASC");
        cursor.moveToFirst();
        while (cursor.moveToNext()) {
            list.add(new ModelContacts(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)),
                    cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))));
        }
        return list;

    }
}