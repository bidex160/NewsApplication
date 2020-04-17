package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class recycleadapter extends RecyclerView.Adapter<recycleadapter.Viewholder>{
List<articles> articlesList = new ArrayList<>();

Context context;

    public recycleadapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layoutview, parent, false);
        Viewholder viewholder = new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, final int position) {
        holder.ettxt.setText(articlesList.get(position).getTitle());
        holder.edsctxt.setText(articlesList.get(position).getDescription());
        holder.edtxt.setText(articlesList.get(position).getPublishedAt());
        Glide.with(context)
                .asBitmap()
                .load(articlesList.get(position).getUrlToImage())
                .into(holder.imageView);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), WebViews.class);
                intent.putExtra("url", articlesList.get(position).getUrl());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        TextView ettxt, edsctxt, edtxt;
        CardView parent;
        ImageView imageView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            ettxt = itemView.findViewById(R.id.etitle);
            edsctxt = itemView.findViewById(R.id.edesc);
            edtxt = itemView.findViewById(R.id.edate);
            parent = itemView.findViewById(R.id.card);
            imageView = itemView.findViewById(R.id.imagev);


        }
    }

    public void setArticlesList(List<articles> articlesList) {
        this.articlesList = articlesList;
        notifyDataSetChanged();
    }
}
