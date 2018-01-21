package com.example.magueye.geronimosample.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.magueye.geronimosample.R;
import com.example.magueye.geronimosample.model.MovieDataModel;
import com.squareup.picasso.Picasso;

/**
 * Created by magueye on 15/01/2018.
 */

public class MyViewHolder  extends RecyclerView.ViewHolder{

    private TextView textViewMovieCat;
    private TextView textViewMovieName;
    private ImageView imageView;
    private Context context;

    public MyViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;

        textViewMovieCat = (TextView) itemView.findViewById(R.id.item_category);
        textViewMovieName = (TextView) itemView.findViewById(R.id.item_name);
        imageView = (ImageView) itemView.findViewById(R.id.item_image);
    }

    //adding datas( name, cat and image) for each movie
    public void bind(MovieDataModel myObject){

        textViewMovieCat.setText(myObject.getCategory());
        textViewMovieName.setText(myObject.getName());
        Picasso.with(imageView.getContext()).load(myObject.getImage()).centerInside().fit().into(imageView);
    }
}
