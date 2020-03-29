package com.example.newsapp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealthFragment extends Fragment {
    RecyclerView recyclerView;
    Entertainmentrecycleadapter adapter;
    Context context;

    public final String api = "3b7a2e1749c041faad5d261804acbe28";
    private static final String TAG ="Started";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.health_fragment_layout, container, false);

        recyclerView = view.findViewById(R.id.healthrecycle);
        adapter = new Entertainmentrecycleadapter(getContext());
        recyclerView.setAdapter(adapter);
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));




       RetrofitClient retrofitClient = retrofitapi.getClient().create(RetrofitClient.class);
        Call<ResponseM> responseMCall = retrofitClient.getAllnews("ng","health", api);
        responseMCall.enqueue(new Callback<ResponseM>() {
            @Override
            public void onResponse(Call<ResponseM> call, Response<ResponseM> response) {
                Log.d(TAG, "onResponse: "+response.code());
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
}
