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

public class DuanziActivity extends AppCompatActivity {

    private RequestUtil mApi;
    private List<DuanziInfo> mDuanziInfos;
    private DuanziAdapter mDuanziAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_layout);
        initView();
        initData();
    }

    private void initView() {
        mDuanziInfos = new ArrayList<>();
        RecyclerView mRecyclerview = findViewById(R.id.recyclerview);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.addItemDecoration(new DividerItemDecoration(this, 1));
        mDuanziAdapter = new DuanziAdapter(R.layout.item_duanzi, mDuanziInfos);
        mRecyclerview.setAdapter(mDuanziAdapter);
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                //使用自定义的mGsonConverterFactory
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.1.238:8080/test/duanzi/")
                .build();
        mApi = retrofit.create(RequestUtil.class);
        Call<List<DuanziInfo>> news = mApi.getDuanziInfo();
        news.enqueue(new Callback<List<DuanziInfo>>() {

            @Override
            public void onResponse(Call<List<DuanziInfo>> call, Response<List<DuanziInfo>> response) {
                //http://127.0.0.1:8080/v1/getpagecity/1
                List<DuanziInfo> mDatas = response.body();
                mDuanziAdapter.setNewData(mDatas);
                Log.e("DHD", "onResponse: " + mDatas);
                Log.e("DHD", "call.request().body(): " + call.request().url());
            }

            @Override
            public void onFailure(Call<List<DuanziInfo>> call, Throwable t) {
                Log.e("DHD", "onFailure: " + t);
            }
        });
    }
}
