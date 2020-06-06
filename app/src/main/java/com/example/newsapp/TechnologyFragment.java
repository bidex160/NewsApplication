package com.example.newsapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class TechnologyFragment extends Fragment {
   recycleadapter adapter;
   RecyclerView recyclerView;
    private AdView mAdView;
    public final String api = "3b7a2e1749c041faad5d261804acbe28";
    private static final String TAG ="technology";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.technology_fragment_layout, container, false);
        initviews(view);

        adapter = new recycleadapter(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = view.findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);




        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.e(TAG, "onAdLoaded: " );
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.e(TAG, "onAdFailedToLoad: " + errorCode);
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });



        RetrofitClient retrofitClient = retrofitapi.getClient().create(RetrofitClient.class);
        Call<ResponseM> responseMCall = retrofitClient.getAllnews("ng", "technology", api);
        responseMCall.enqueue(new Callback<ResponseM>() {
            @Override
            public void onResponse(Call<ResponseM> call, Response<ResponseM> response) {
                Log.d(TAG, "onResponse: "+ response.code());
                if (response.body().getStatus().equals("ok")){
                    List<articles> articles = response.body().getArticles();
                    if (articles.size()>0){
                       adapter.setArticlesList(articles);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseM> call, Throwable t) {

            }
        });




        return view;


    }

    private void initviews(View view) {
        recyclerView = view.findViewById(R.id.technologyrecycle);

    }
}
