package com.dhd.crowerdemo;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/5/22.
 */

public class CityAdapter extends BaseQuickAdapter<CrowerInfo, BaseViewHolder> {


    public CityAdapter(int layoutResId, @Nullable List<CrowerInfo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, CrowerInfo item) {
        holder.setText(R.id.tv_name, item.getCityname());
        holder.setText(R.id.tv_url, item.getCityurl());
    }
}
