package com.gtja.ydpt.imei.androidId.kafka.producer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by HuoHui on 2017/07/27.
 */

@Configuration
@ConfigurationProperties(prefix = "newStockCalenderProducerConfig")
public class StockMessageProducerConfig extends KafkaProducerConfig{
}
