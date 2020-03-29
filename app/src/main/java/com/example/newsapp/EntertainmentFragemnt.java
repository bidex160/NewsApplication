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
import retrofit2.Retrofit;



public class EntertainmentFragemnt extends Fragment {
    public final String api = "3b7a2e1749c041faad5d261804acbe28";
    private static final String TAG ="Started";
    RecyclerView recyclerView;
    Entertainmentrecycleadapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.entertainment_fragment_layout, container, false);
        initviews(view);
         adapter = new Entertainmentrecycleadapter(getContext());
         recyclerView.setAdapter(adapter);
         recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));













       RetrofitClient retrofitClient = retrofitapi.getClient().create(RetrofitClient.class);
        Call<ResponseM> responseMCall = retrofitClient.getAllnews("ng", "entertainment", api);
        responseMCall.enqueue(new Callback<ResponseM>() {
            @Override
            public void onResponse(Call<ResponseM> call, Response<ResponseM> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.body().getStatus().equals("ok")){
                    List<articles> articles = response.body().getArticles();
                    if (articles.size()>0){
                        adapter.setArticlesList(articles);

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseM> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getMessage());

            }
        });























        return view;


    }

    private void initviews(View view) {
        recyclerView = view.findViewById(R.id.entertainmentrecycle);
    }
}
