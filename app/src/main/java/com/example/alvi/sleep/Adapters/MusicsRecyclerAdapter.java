/*
 * Created by Alvi Khalil on 11/2/18 3:28 PM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 11/2/18 3:19 PM
 *
 */

package com.example.alvi.sleep.Adapters;


import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.alvi.sleep.Classes.Musics;
import com.example.alvi.sleep.Details;
import com.example.alvi.sleep.R;

import java.util.List;


public class MusicsRecyclerAdapter extends RecyclerView.Adapter<MusicsRecyclerAdapter.CustomViewHolder> {
    private List<Musics> feedItemList;
    private Context mContext;



    public MusicsRecyclerAdapter(Context context, List<Musics> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;



    }

    @Override
    public int getItemViewType(int position) {

        return 1;

    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {

            case 1:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_list_view, parent, false);
                CustomViewHolder row = new CustomViewHolder(view,1);
                return row;

        }
        return null;
    }


    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        final Musics dc_list = feedItemList.get(position);





            holder.image.setImageResource(dc_list.getImage());

            holder.header.setText(dc_list.getHeader());
            holder.body.setText(dc_list.getBody());
//            gluideLoader(""+dc_list.getImage(),holder.image);

            holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent= new Intent(mContext,Details.class);
                    intent.putExtra("Image",dc_list.getImage());
                    intent.putExtra("Name",dc_list.getHeader());
                    mContext.startActivity(intent);

                }
            });








    }


    @Override
    public int getItemCount() {
        return feedItemList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {



        ImageView image;
        TextView header;
        TextView body;

        ConstraintLayout constraintLayout;



        public CustomViewHolder(View itemView,int item) {
            super(itemView);



            image = itemView.findViewById(R.id.image);

            header = itemView.findViewById(R.id.header);
            body = itemView.findViewById(R.id.body);
            constraintLayout = itemView.findViewById(R.id.music_cons_layout);



        }
    }
}