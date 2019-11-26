package com.example.a99710.myapplication;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by 99710 on 2019/11/27.
 */

public class OrderInfo implements Serializable{
    private int id;
    private float distance;
    private float remainTime;
    private int headIcon;
    private float score;
    private String startAddress;
    private String endAddress;
    private int phoneNum;
    private String name;

    public OrderInfo(float distance,float remainTime,int headIcon,float score,int phoneNum,String startAddress,String endAddress,String name) {
        this.distance=distance;
        this.endAddress=endAddress;
        this.headIcon=headIcon;
        this.phoneNum=phoneNum;
        this.startAddress=startAddress;
        this.score=score;
        this.remainTime=remainTime;
        this.name=name;
    }

    public float getDistance()
    {
        return distance;
    }

    public float getRemainTime()
    {
        return remainTime;
    }
    public float getScore()
    {
        return score;
    }
    public int getHeadIcon()
    {
        return headIcon;
    }
    public int getPhoneNum()
    {
        return phoneNum;
    }
    public String getStartAddress()
    {
        return startAddress;
    }
    public String getEndAddress()
    {
        return endAddress;
    }
    public  String getName()
    {
        return name;
    }


}
