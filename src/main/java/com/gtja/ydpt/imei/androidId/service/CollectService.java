package com.gtja.ydpt.imei.androidId.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gtja.ydpt.imei.androidId.dao.CollectDao;
import com.gtja.ydpt.imei.androidId.model.Collect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
/*
     private int id;
    private String imei;
    private String androidID;
    private String deviceInfo;
    private String androidSystemVersion;
    private String jhVersion;
    private Date createTime;
    private Date updateTime;
    ////////////
    {"androidID":"1",
"androidSystemVersion":"1",
"createTime":"1",
"deviceInfo":"1",
"id":0,
"imei":"哈哈",
"jhVersion":"1",
"updateTime":"1"}
 */
@Service
public class CollectService {

    @Autowired
    CollectDao collectDao;
    @Autowired
    Collect collect;


    public int  addCollect(String collectStr)
    {
       // final String[] split = collectStr.split(",");
        JSONObject  jsonObject = JSON.parseObject(collectStr);
        collect.setImei(jsonObject.getString("imei"));
        collect.setAndroidID(jsonObject.getString("androidID"));
        collect.setAndroidSystemVersion(jsonObject.getString("androidSystemVersion"));
        collect.setDeviceInfo(jsonObject.getString("deviceInfo"));
        collect.setJhVersion(jsonObject.getString("jhVersion"));
        collect.setCreateTime(new Date());
        System.out.println("stockMessageConsumer addCollect"+collect.toString());
        return collectDao.addCollect(collect);
    }
}
