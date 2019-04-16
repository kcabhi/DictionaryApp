package com.e.hotel_recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.ArrayList;

public  class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private ArrayList<ItemS> alphaarraylist;
    private RvClickListener listener;

    public MyAdapter( Context context, ArrayList<ItemS> alphaArrayList){
        alphaarraylist = alphaArrayList;
        listener = (RvClickListener) context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView=
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_hotel,viewGroup,false);
        return  new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        final ItemS alpha=alphaarraylist.get(i);
//        myViewHolder.nametv.setText(alpha.getImg());
        myViewHolder.contv.setText(alpha.getName());
        myViewHolder.addtv.setText(String.valueOf(alpha.getId()));

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(alpha);

            }
        });
    }

    @Override
    public int getItemCount() {
        return alphaarraylist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView addtv, contv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

//
//            nametv=itemView.findViewById(R.id.name_tv);
            addtv=itemView.findViewById(R.id.add_tv);
            contv=itemView.findViewById(R.id.con_tv);
        }
    }}