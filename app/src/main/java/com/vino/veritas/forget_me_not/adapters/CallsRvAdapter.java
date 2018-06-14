package com.example.vishnusmurali.caller.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vishnusmurali.caller.R;
import com.example.vishnusmurali.caller.models.ModelCalls;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Vishnu S Murali on 13-06-2018.
 */

public class CallsRvAdapter extends RecyclerView.Adapter<CallsRvAdapter.ViewHolder> {
private LayoutInflater layoutInflater;
private  Context mContext;

private List<ModelCalls> mlistCalls;

public  CallsRvAdapter(Context context,List<ModelCalls> listCalls){
    mContext=context;
    mlistCalls=listCalls;
}
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView number,duration,date;


        public ViewHolder(View itemView) {
            super(itemView);
            number= (TextView) itemView.findViewById(R.id.contact_number);
            duration=(TextView) itemView.findViewById(R.id.call_duration);
            date=(TextView) itemView.findViewById(R.id.call_date);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    layoutInflater =LayoutInflater.from(mContext);
    View view=layoutInflater.inflate(R.layout.item_calls,parent,false);
    ViewHolder viewHolder=new ViewHolder(view);
    return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView number,date,duration;
        number=holder.number;
        duration=holder.duration;
        date=holder.date;
        number.setText(mlistCalls.get(position).getNumber());
        duration.setText(mlistCalls.get(position).getDuration());
        date.setText(mlistCalls.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return mlistCalls.size();
    }


}
