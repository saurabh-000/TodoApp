package com.symb.task.todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Todo> mDatasets;
    public MyAdapter(ArrayList<Todo> myDataset){
        mDatasets=myDataset;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view,parent,false);
        MyViewHolder vh=new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Todo object=mDatasets.get(position);
        holder.textdesc.setText(object.desc);
        holder.textdate.setText(object.date);
    }

    @Override
    public int getItemCount() {
        return mDatasets.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textdesc,textdate;
        public MyViewHolder(View v){
            super(v);
            this.textdesc=(TextView) v.findViewById(R.id.my_text);
            this.textdate=(TextView) v.findViewById(R.id.timeText);
        }
    }

}
