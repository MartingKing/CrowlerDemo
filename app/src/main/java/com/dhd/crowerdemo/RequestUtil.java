package com.dhd.crowerdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2018/6/6.
 */

public interface RequestUtil {
    @GET("getpagecity/{offset}")
    Call<List<CrowerInfo>> getCityInfo(@Path("offset") int num);

    @GET("getallduanzi")
    Call<List<DuanziInfo>> getDuanziInfo();
}
