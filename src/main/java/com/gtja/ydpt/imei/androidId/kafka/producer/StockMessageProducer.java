package com.gtja.ydpt.imei.androidId.kafka.producer;


import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by HuoHui on 2017/09/11.
 */
@Component
public class StockMessageProducer extends  AbstractKafkaProducer {
    @Autowired
    private StockMessageProducerConfig subRelationProducerConfig;

    @Override
    public void send(String key, String value) {

        producer.send(new ProducerRecord<String, String>(subRelationProducerConfig.getTopic(), key, value));
        producer.close();
    }

    @Override
    public KafkaProducerConfig getKafkaProducerConfig() {
        return subRelationProducerConfig;
    }
}
