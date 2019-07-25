package com.gtja.ydpt.imei.androidId.kafka.producer;

import java.util.Properties;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Created by meikebo on 2016/8/12.
 */
@Component
public abstract class AbstractKafkaProducer implements InitializingBean,DisposableBean {

    protected Producer<String, String> producer;


    @Override
    public void destroy() throws Exception {
        producer.close();

    }

    public abstract void send(String key, String value);

    @Override
    public void afterPropertiesSet() throws Exception {

        Properties props = new Properties();
        props.put("bootstrap.servers", getKafkaProducerConfig().getBootstrapServers());
        props.put("acks", getKafkaProducerConfig().getAcks());
        props.put("retries", getKafkaProducerConfig().getRetries());
        props.put("batch.size", getKafkaProducerConfig().getBatchSize());
        props.put("linger.ms", getKafkaProducerConfig().getLingerMs());
        props.put("buffer.memory", getKafkaProducerConfig().getBufferMemory());
        props.put("key.serializer", getKafkaProducerConfig().getKeySerializer());
        props.put("value.serializer", getKafkaProducerConfig().getValueSerializer());
        producer = new KafkaProducer<String, String>(props);
    }

    public abstract KafkaProducerConfig getKafkaProducerConfig();

}
