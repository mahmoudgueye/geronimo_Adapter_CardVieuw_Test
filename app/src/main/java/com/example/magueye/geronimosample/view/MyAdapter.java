package com.example.magueye.geronimosample.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import com.example.magueye.geronimosample.R;
import com.example.magueye.geronimosample.model.MovieDataModel;

import java.util.List;

/**
 * Created by magueye on 15/01/2018.
 */

public class MyAdapter  extends RecyclerView.Adapter<MyViewHolder> {

    List<MovieDataModel> list;
    private TextView tvDetails ;
    private TextView tvSharing;
    private MovieDataModel myObject;
    private  Context context;

    public MyAdapter(Context context, List<MovieDataModel> list) {
        this.list = list;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_item,viewGroup,false);

        //show details
        tvDetails = (TextView) view.findViewById(R.id.tvdetails);
        tvDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), myObject.getDetails(), Toast.LENGTH_LONG).show();
            }
        });

        //show sharing options
        tvSharing = (TextView) view.findViewById(R.id.tvshare) ;
        tvSharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Hello : "+myObject.getCategory();
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                view.getContext().startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });

        return new MyViewHolder(view,context );
    }


    @Override
    public void onBindViewHolder( MyViewHolder myViewHolder, int position) {
        MovieDataModel myObject = list.get(position);
        this.myObject = myObject;
        myViewHolder.bind(myObject);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
