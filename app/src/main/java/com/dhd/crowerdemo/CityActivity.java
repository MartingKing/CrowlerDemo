package com.dhd.crowerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/6/6.
 */

public class CityActivity extends AppCompatActivity {
    private RequestUtil mApi;
    private List<CrowerInfo> mCrowerInfos;
    private CityAdapter mCrowerAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_layout);
        initView();
        initData();
    }


    private void initView() {
        mCrowerInfos = new ArrayList<>();
        RecyclerView mRecyclerview = findViewById(R.id.recyclerview);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.addItemDecoration(new DividerItemDecoration(this, 1));
        mCrowerAdapter = new CityAdapter(R.layout.item_city, mCrowerInfos);
        mRecyclerview.setAdapter(mCrowerAdapter);
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                //使用自定义的mGsonConverterFactory
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.1.238:8080/test/city/")
                .build();
        mApi = retrofit.create(RequestUtil.class);
        Call<List<CrowerInfo>> news = mApi.getCityInfo(1);
        news.enqueue(new Callback<List<CrowerInfo>>() {

            @Override
            public void onResponse(Call<List<CrowerInfo>> call, Response<List<CrowerInfo>> response) {
                //http://127.0.0.1:8080/v1/getpagecity/1
                List<CrowerInfo> mDatas = response.body();
                mCrowerAdapter.setNewData(mDatas);
                Log.e("DHD", "onResponse: " + mDatas);
                Log.e("DHD", "call.request().body(): " + call.request().url());
            }

            @Override
            public void onFailure(Call<List<CrowerInfo>> call, Throwable t) {
                Log.e("DHD", "onFailure: " + t);
            }
        });
    }
}
