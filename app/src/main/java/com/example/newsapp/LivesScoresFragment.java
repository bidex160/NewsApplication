package com.example.newsapp;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class LivesScoresFragment extends Fragment {
      RecyclerView recyclerView;
      liveScoresadapter liveScoresadapter;
      ProgressBar progressBar;
    public final static String sporturl = "http://api.isportsapi.com/";
    public final String api = "f8OwTJtiPnG5sCsa";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view1 = inflater.inflate(R.layout.livescore_fragment, container, false);
          progressBar = view1.findViewById(R.id.progresbar);
        recyclerView = view1.findViewById(R.id.scorerecycle);
        liveScoresadapter = new liveScoresadapter(getContext());
        recyclerView.setAdapter(liveScoresadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(sporturl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitClient retrofitClient = retrofit.create(RetrofitClient.class);
        Call<LiveResponse> liveResponseCall = retrofitClient.getallive(api);
        liveResponseCall.enqueue(new Callback<LiveResponse>() {
            @Override
            public void onResponse(Call<LiveResponse> call, Response<LiveResponse> response) {
                Log.d(TAG, "onResponse:iii " + response.code());
                Log.d(TAG, "onResponse:iiiii " + response.body().getMessage());
                // Log.d(TAG, "onResponse: " + response.body().getLiveScores().size());
                if (response.body().getMessage().equals("success")){
                    List<LiveScores> livedata = response.body().getLiveScores();
                 //   Log.d(TAG, "onResponse:ii "+ livedata.get(67).getLeagueName());
                     progressBar.setVisibility(View.INVISIBLE);

                  //    Log.d(TAG, "onResponse: elapse:-" + (System.currentTimeMillis() - 1588616100 * 1000L));
                    //    Log.d(TAG, "onResponse: long:-" + 1588616100 * 1000L);
                      //  String timexx = new SimpleDateFormat("SS")
                        //.format(1588616100 * 1000L);
                   // Log.d(TAG, "onResponse:saa:= " + SystemClock.elapsedRealtime());

                        String times = new SimpleDateFormat("HH:mm")
                            .format(1588616100);
                    Log.d(TAG, "onResponse:con:- " + times);
                    for (int i=0; i<livedata.size(); i++){
                        Log.d(TAG, "onResponse: " + livedata.get(i).getStatus() + livedata.get(i).getHomeName());
                        if (livedata.get(i).getStatus() == 1){
                            Log.e(TAG, "onResponse: first halfetime" );
                            Log.e(TAG, "onResponse: time"+ livedata.get(i).getHalfStartTime() );
                        }




                }

                    liveScoresadapter.setLiveScores(livedata);

                }
            }

            @Override
            public void onFailure(Call<LiveResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getMessage());
            }
        });



       return view1;
    }
}
