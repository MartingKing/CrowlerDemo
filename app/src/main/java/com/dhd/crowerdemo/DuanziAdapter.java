package com.dhd.crowerdemo;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/5/22.
 */

public class DuanziAdapter extends BaseQuickAdapter<DuanziInfo, BaseViewHolder> {


    public DuanziAdapter(int layoutResId, @Nullable List<DuanziInfo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, DuanziInfo item) {
        holder.setText(R.id.tv_title, item.getTittle());
        holder.setText(R.id.tv_content, item.getContents());
    }
}
