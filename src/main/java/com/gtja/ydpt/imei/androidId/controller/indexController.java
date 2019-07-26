package com.gtja.ydpt.imei.androidId.controller;

import com.alibaba.fastjson.JSONObject;
import com.gtja.ydpt.imei.androidId.kafka.producer.StockMessageProducer;
import com.gtja.ydpt.imei.androidId.model.Collect;
import com.gtja.ydpt.imei.androidId.service.CollectService;
import com.gtja.ydpt.imei.androidId.util.imeiUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class indexController {

    @Autowired
    StockMessageProducer stockMessageProducer;

    private static final Logger logger = LoggerFactory.getLogger(indexController.class);
    @RequestMapping(path = {"/imei/androidID/collect"},method = {RequestMethod.POST})
    @ResponseBody
    public String addMessage(@RequestBody Collect collect)
    {
        try {
            System.out.println(collect.toString()+"controller2");
            //return "消息发送成功";

            //kafka 推送
            //stockMessageProducer.send("key","123");
            stockMessageProducer.send("key", JSONObject.toJSONString(collect));

            return imeiUtil.getJSONString(0,"消息发送成功@:"+collect.toString());
        }catch (Exception e)
        {
            logger.error("消息发送失败"+e.getMessage());
            return imeiUtil.getJSONString(1,"消息发送失败");
        }
    }

    @RequestMapping(path = {"/"},method = {RequestMethod.POST})
     @ResponseBody
    public String Message()
    {
        try {
            return imeiUtil.getJSONString(0,"消息发送成功!!");
        }catch (Exception e)
        {
            logger.error("消息发送失败"+e.getMessage());
            return imeiUtil.getJSONString(1,"消息发送失败");
        }
    }
}
