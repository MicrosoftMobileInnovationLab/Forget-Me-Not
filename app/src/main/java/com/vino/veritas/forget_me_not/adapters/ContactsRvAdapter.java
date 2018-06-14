package com.example.vishnusmurali.caller.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vishnusmurali.caller.R;
import com.example.vishnusmurali.caller.models.ModelContacts;

import java.util.List;

/**
 * Created by Vishnu S Murali on 13-06-2018.
 */

public class ContactsRvAdapter extends RecyclerView.Adapter<ContactsRvAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<ModelContacts>mlistContacts;
    private Context mcontext;
    public ContactsRvAdapter(Context context,List<ModelContacts>listContacts){
        mlistContacts=listContacts;
        mcontext=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater=LayoutInflater.from(mcontext);
        View view=inflater.inflate(R.layout.items_contacts,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            TextView contact_name,contact_number;
            contact_name=holder.contact_name;
            contact_number=holder.contact_number;
            contact_name.setText(mlistContacts.get(position).getName());
            contact_number.setText(mlistContacts.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return mlistContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView contact_name,contact_number;
        public ViewHolder(View itemView) {
            super(itemView);
            contact_name=itemView.findViewById(R.id.contact_name);
            contact_number=itemView.findViewById(R.id.contact_number);
        }
    }
}
