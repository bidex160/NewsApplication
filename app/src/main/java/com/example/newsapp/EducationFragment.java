package com.example.newsapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class EducationFragment extends Fragment {
    RecyclerView recyclerView;
    private  final static  String url ="https://api.covid19api.com/";
   private covidadpater adapter;
    private static final String AD_UNIT_ID = "ca-app-pub-4550012335327153/4750422438";
    private InterstitialAd interstitialAd;
    private static final String TAG ="ology";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.education_fragment_layout, container, false);
        initviews(view);
        //textView.setText("Education");
        adapter = new covidadpater(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        MobileAds.initialize(getContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        // Create the InterstitialAd and set the adUnitId.
        interstitialAd = new InterstitialAd(getContext());
        // Defined in res/values/strings.xml
        interstitialAd.setAdUnitId(AD_UNIT_ID);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        interstitialAd.loadAd(adRequest);

        if (interstitialAd != null && interstitialAd.isLoaded()) {
            Log.e(TAG, "onCreateView: " );

        }

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                Log.e(TAG, "onAdLoaded: " );
                //Toast.makeText(MyActivity.this, "onAdLoaded()", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.e(TAG, "onAdFailedToLoad: "+errorCode );

            }

            @Override
            public void onAdClosed() {

            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                               .baseUrl(url)
                               .addConverterFactory(GsonConverterFactory.create())
                               .build();
         RetrofitClient retrofitClient = retrofit.create(RetrofitClient.class);
         Call<ReGlobal> globalCall = retrofitClient.getglobal();
         globalCall.enqueue(new Callback<ReGlobal>() {
             @Override
             public void onResponse(Call<ReGlobal> call, Response<ReGlobal> response) {
                 Log.e(TAG, "onResponse: "+response.message() );
                if (response.body() != null){

                    List<CovidCountries> covidCountries = response.body().getCountries();
                    adapter.setGlobals(covidCountries);
                    Log.e(TAG, "onResponse:b "+response.body().getCountries().get(1).getCountry() );
                }
             }

             @Override
             public void onFailure(Call<ReGlobal> call, Throwable t) {
                 Log.e(TAG, "onFailure: "+ t.getMessage() );

             }
         });

        return view;
    }

    private void initviews(View view) {
        recyclerView = view.findViewById(R.id.recycleedu);
    }



}
