package com.example.a99710.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by 99710 on 2019/11/27.
 */

public class OrderAdapter extends BaseAdapter {

    private LinkedList<OrderInfo> mData;
    private Context mContext;

    public OrderAdapter(LinkedList<OrderInfo> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.order_item,parent,false);
        ImageView img_icon = (ImageView) convertView.findViewById(R.id.HeadIcon);
        TextView score = (TextView) convertView.findViewById(R.id.OrderScore);
        TextView timedist = (TextView) convertView.findViewById(R.id.OrderTimeDis);
        img_icon.setBackgroundResource(mData.get(position).getHeadIcon());
        score.setText(Float.toString(mData.get(position).getScore())+"积分");
        timedist.setText(mData.get(position).getDistance()+"米"+"    "+"配送"+"剩余"+mData.get(position).getRemainTime()+"分钟");
        return convertView;
    }
}

