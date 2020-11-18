package com.example.alvi.sleep.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.alvi.sleep.Classes.Musics;
import com.example.alvi.sleep.Classes.Optons;
import com.example.alvi.sleep.R;


import java.util.ArrayList;

public class HorizontalRecyclerAdapter extends RecyclerView.Adapter<HorizontalRecyclerAdapter.ViewHolder> {


    private ArrayList<Optons> mImages = new ArrayList<>();
    private Context mContext;
    private int position_of_clicked_image;
    View view;


    public HorizontalRecyclerAdapter(ArrayList<Optons> mImages, Context mContext) {
        this.mImages = mImages;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {


        final Optons dc_list = mImages.get(position);

        holder.miniImage.setImageResource(dc_list.getImage());

        holder.textView.setText(dc_list.getName());


//        if(position==0){
//            holder.constraintLayout.setBackgroundColor(Color.parseColor("#8E97FD"));
//            holder.textView.setTextColor(Color.parseColor("#ffffff"));
//        }

    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView miniImage;
        ConstraintLayout constraintLayout;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            miniImage = itemView.findViewById(R.id.mini_image);
            constraintLayout = itemView.findViewById(R.id.cons_of_hor);
            textView = itemView.findViewById(R.id.text);
        }
    }
}
