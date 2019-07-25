package com.gtja.ydpt.imei.androidId.kafka.consumer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//import com.ydpt.common.kafka.consumer.KafkaConsumerConfig;
//
@Configuration
@ConfigurationProperties(prefix="newStockCalenderConsumerConfig")
public class StockMessageConsumerConfig extends KafkaConsumerConfig{

}
