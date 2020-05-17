package com.example.newsapp;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import android.util.TimeFormatException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class liveScoresadapter extends RecyclerView.Adapter<liveScoresadapter.viewholder> {
   List<LiveScores> liveScores = new ArrayList<>();
   Context context;


    public liveScoresadapter(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.livescores_recycle_layout, null);
        viewholder viewholder = new viewholder(view1);
        return viewholder;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.leaguename.setText(liveScores.get(position).getLeagueName());

        holder.homename.setText(liveScores.get(position).getHomeName());
        holder.awayname.setText(liveScores.get(position).getAwayName());

        if (liveScores.get(position).getLeagueType() == 1){
            holder.type.setText("League:-");
        }else {
            holder.type.setText("Cup:-");
        }


       if (liveScores.get(position).getStatus() == 0){
           String dateAsText = new SimpleDateFormat("dd-MM")
                   .format(new Date(liveScores.get(position).getMatchTime() * 1000L));

           String times = new SimpleDateFormat("HH:mm")
                   .format(new Date(liveScores.get(position).getMatchTime() * 1000L));
           holder.date.setText(dateAsText);
           holder.starttime.setText(times);

           holder.homescore.setText("0");
           holder.awayscore.setText("0");
           holder.chronometer.setVisibility(View.INVISIBLE);
           Log.e(TAG, "onBindViewHolder: not started" + liveScores.get(position).getHomeName());


       }else if (liveScores.get(position).getStatus() == 4){
           String dateAsText = new SimpleDateFormat("dd-MM")
                   .format(new Date(liveScores.get(position).getMatchTime() * 1000L));

           String times = new SimpleDateFormat("HH:mm")
                   .format(new Date(liveScores.get(position).getMatchTime() * 1000L));
           holder.date.setText(dateAsText);
           holder.starttime.setText(times);

           holder.homescore.setText("?");
           holder.awayscore.setText("?");

           holder.chronometer.setVisibility(View.INVISIBLE);

       }else if (liveScores.get(position).getStatus() == 5){
           String dateAsText = new SimpleDateFormat("dd-MM")
                   .format(new Date(liveScores.get(position).getMatchTime() * 1000L));

           String times = new SimpleDateFormat("HH:mm")
                   .format(new Date(liveScores.get(position).getMatchTime() * 1000L));
           holder.date.setText(dateAsText);
           holder.starttime.setText(times);

           holder.homescore.setText("?");
           holder.awayscore.setText("?");
           holder.chronometer.setVisibility(View.INVISIBLE);

       }else if (liveScores.get(position).getStatus() == -10){
           String dateAsText = new SimpleDateFormat("dd-MM")
                   .format(new Date(liveScores.get(position).getMatchTime() * 1000L));

           String times = new SimpleDateFormat("HH:mm")
                   .format(new Date(liveScores.get(position).getMatchTime() * 1000L));
           holder.date.setText(dateAsText);
           holder.starttime.setText(times);


           holder.homescore.setText("?");
           holder.awayscore.setText("?");
           holder.awayscore.setTextColor(context.getResources().getColor(R.color.gray));
           holder.homescore.setTextColor(context.getResources().getColor(R.color.gray));
           long x = System.currentTimeMillis()- 1588616100*1000L;

           //holder.chronometer.setBase(1588616100);
           //holder.chronometer.setFormat("MM:SS");
           holder.chronometer.setText("Canc");
         //  holder.mat.setText("Canc");

       }else if (liveScores.get(position).getStatus() == -11){
           String dateAsText = new SimpleDateFormat("dd-MM")
                   .format(new Date(liveScores.get(position).getMatchTime() * 1000L));

           String times = new SimpleDateFormat("HH:mm")
                   .format(new Date(liveScores.get(position).getMatchTime() * 1000L));
           holder.date.setText(dateAsText);
           holder.starttime.setText(times);
           holder.homescore.setText("?");
           holder.awayscore.setText("?");
           holder.awayscore.setTextColor(context.getResources().getColor(R.color.gray));
           holder.homescore.setTextColor(context.getResources().getColor(R.color.gray));
          // holder.mat.setText("TBD");
           holder.chronometer.setText("TBD");

       }else if (liveScores.get(position).getStatus() == -12){
           String dateAsText = new SimpleDateFormat("dd-MM")
                   .format(new Date(liveScores.get(position).getMatchTime() * 1000L));

           String times = new SimpleDateFormat("HH:mm")
                   .format(new Date(liveScores.get(position).getMatchTime() * 1000L));
           holder.date.setText(dateAsText);
           holder.starttime.setText(times);
           holder.homescore.setText("?");
           holder.awayscore.setText("?");
           holder.awayscore.setTextColor(context.getResources().getColor(R.color.gray));
           holder.homescore.setTextColor(context.getResources().getColor(R.color.gray));
           holder.chronometer.setVisibility(View.INVISIBLE);
           holder.chronometer.setText("TRMD");
          // holder.mat.setText("TRMD");

       }else if (liveScores.get(position).getStatus() == -13){
           String dateAsText = new SimpleDateFormat("dd-MM")
                   .format(new Date(liveScores.get(position).getMatchTime() * 1000L));

           String times = new SimpleDateFormat("HH:mm")
                   .format(new Date(liveScores.get(position).getMatchTime() * 1000L));
           holder.date.setText(dateAsText);
           holder.starttime.setText(times);

           holder.homescore.setText("?");
           holder.awayscore.setText("?");

           holder.awayscore.setTextColor(context.getResources().getColor(R.color.gray));
           holder.homescore.setTextColor(context.getResources().getColor(R.color.gray));
           holder.chronometer.setVisibility(View.INVISIBLE);

           holder.chronometer.setText("INTRP");

     //      holder.mat.setText("INTRP");

       }else if (liveScores.get(position).getStatus() == -14){
           String dateAsText = new SimpleDateFormat("dd-MM")
                   .format(new Date(liveScores.get(position).getMatchTime() * 1000L));

           String times = new SimpleDateFormat("HH:mm")
                   .format(new Date(liveScores.get(position).getMatchTime() * 1000L));
           holder.date.setText(dateAsText);
           holder.starttime.setText(times);

           holder.homescore.setText("?");
           holder.awayscore.setText("?");

           holder.awayscore.setTextColor(context.getResources().getColor(R.color.gray));
           holder.homescore.setTextColor(context.getResources().getColor(R.color.gray));

           holder.chronometer.setText("PST");
          // holder.mat.setText("PST");

       }else {

           /**
           *chromoter function
            */
          if (liveScores.get(position).getStatus() == 1) {

              String dateAsText = new SimpleDateFormat("dd-MM")
                      .format(new Date(liveScores.get(position).getMatchTime() * 1000L));

              String times = new SimpleDateFormat("HH:mm")
                      .format(new Date(liveScores.get(position).getMatchTime() * 1000L));
              holder.date.setText(dateAsText);
              holder.starttime.setText(times);

              if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
                  LocalDateTime localDateTime = LocalDateTime.now();
                  //  Log.d(TAG, "onBindViewHolder:f " + localDateTime.format(dtf));
                  if (localDateTime.format(dtf) == times) {
                      holder.chronometer.start();

                  }
                  //   Log.e(TAG, "onBindViewHolder: time " + liveScores.get(position) );
              }
              holder.homescore.setText("?");
              holder.awayscore.setText("?");
              holder.chronometer.setVisibility(View.INVISIBLE);
              Log.e(TAG, "onBindViewHolder: firsthalfstarted " + liveScores.get(position).getHomeName());
          }else if (liveScores.get(position).getStatus() == -1) {
              String dateAsText = new SimpleDateFormat("dd-MM")
                      .format(new Date(liveScores.get(position).getMatchTime() * 1000L));

              String times = new SimpleDateFormat("HH:mm")
                      .format(new Date(liveScores.get(position).getMatchTime() * 1000L));


              holder.date.setText(dateAsText);
              holder.starttime.setText(times);
              holder.homescore.setText(String.valueOf(liveScores.get(position).getHomeScore()));
              holder.homescore.setTextColor(context.getResources().getColor(R.color.colorAccent));

              holder.awayscore.setTextColor(context.getResources().getColor(R.color.colorAccent));
              holder.awayscore.setText(String.valueOf(liveScores.get(position).getAwayScore()));
              holder.chronometer.setBase(liveScores.get(position).getHalfStartTime());

              // Log.d(TAG, "onBindViewHolder: "+ );
              holder.chronometer.setText("90+");
              // holder.mat.setText("90+");
          }else if (liveScores.get(position).getStatus() == 2){
              String dateAsText = new SimpleDateFormat("dd-MM")
                      .format(new Date(liveScores.get(position).getMatchTime() * 1000L));

              String times = new SimpleDateFormat("HH:mm")
                      .format(new Date(liveScores.get(position).getMatchTime() * 1000L));
              holder.date.setText(dateAsText);
              holder.starttime.setText(times);

              holder.homescore.setText("?");
              holder.awayscore.setText("?");
              holder.chronometer.setVisibility(View.INVISIBLE);

          }else if (liveScores.get(position).getStatus() == 3){
              String dateAsText = new SimpleDateFormat("dd-MM")
                      .format(new Date(liveScores.get(position).getMatchTime() * 1000L));

              String times = new SimpleDateFormat("HH:mm")
                      .format(new Date(liveScores.get(position).getMatchTime() * 1000L));
              holder.date.setText(dateAsText);
              holder.starttime.setText(times);

              holder.homescore.setText("?");
              holder.awayscore.setText("?");
              holder.chronometer.setVisibility(View.INVISIBLE);

          }
       }



    }

    @Override
    public int getItemCount() {
        return liveScores.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView homename, awayname,awayscore, homescore, leaguename, date, dot, starttime, type;
        Chronometer chronometer;
        CardView cardView;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            homename = itemView.findViewById(R.id.homename);
            awayname = itemView.findViewById(R.id.awayname);
            homescore = itemView.findViewById(R.id.homescore);
            awayscore = itemView.findViewById(R.id.awayscore);
            leaguename = itemView.findViewById(R.id.leaguename);
            date = itemView.findViewById(R.id.leaguedate);
            chronometer = itemView.findViewById(R.id.chro);
            starttime = itemView.findViewById(R.id.startime);
            type = itemView.findViewById(R.id.leaguetupe);
          // cardView = itemView.findViewById(R.id.cardview);
        }
    }

    public void setLiveScores(List<LiveScores> liveScores) {
        this.liveScores = liveScores;
        notifyDataSetChanged();
    }
}
