package com.gtja.ydpt.imei.androidId.kafka.consumer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


/**
 * Created by zhoulei on 2016/8/11.
 */
public abstract class AbstractKafkaConsumer implements InitializingBean,DisposableBean {
    private static final Logger logger = LoggerFactory.getLogger(AbstractKafkaConsumer.class);

    private static final String ZOOKEEPER_CONNECT = "zookeeper.connect";
    private static final String GROUP_ID = "group.id";
    private static final String TOPIC = "topic";
    private static final String AUTO_COMMIT_ENABLE = "auto.commit.enable";
    private static final String AUTO_COMMIT_INTERVAL_MS = "auto.commit.interval.ms";
    private static final String REBLANCE_MAX_RETRIES = "rebalance.max.retries";
    private static final String AUTO_OFFSET_RESET = "auto.offset.reset";

    private ConsumerConnector consumer;
    private ExecutorService executor;

    public void destroy(){

        if(consumer != null) consumer.shutdown();
        if(executor != null) executor.shutdown();
        try{
            if(!executor.awaitTermination(5000, TimeUnit.MILLISECONDS)){
                logger.debug("Timed out waiting for consumer threads to shut down, exiting uncleanly");
            }
        }catch(Exception  e){
            logger.debug("Interrupted during shutdown, exiting uncleanly");
        }

    }

    public void afterPropertiesSet(){

        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(createConsumerConfig());
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        String topic = getKafkaConsumerConfig().getTopic();
        Integer a_numberThreads = Integer.valueOf(getKafkaConsumerConfig().getClient_num());
        topicCountMap.put(topic, a_numberThreads);
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);
        executor = Executors.newFixedThreadPool(a_numberThreads);
        for(final KafkaStream<byte[], byte[]> stream : streams){
            executor.submit(new Runnable(){

                @Override
                public void run() {
                    //做具体业务


                    doBusiness(stream);
                }

            });
        }

    }

    public abstract void doBusiness(KafkaStream<byte[], byte[]> stream);

    private ConsumerConfig createConsumerConfig(){
        Properties props = new Properties();
        props.put(ZOOKEEPER_CONNECT, getKafkaConsumerConfig().getZookeeper_connect());
        props.put(GROUP_ID, getKafkaConsumerConfig().getGroup_id());
        props.put(TOPIC, getKafkaConsumerConfig().getTopic());
        props.put(AUTO_COMMIT_ENABLE, getKafkaConsumerConfig().getAuto_commit_enable());
        props.put(AUTO_COMMIT_INTERVAL_MS, getKafkaConsumerConfig().getAuto_commit_interval_ms());
        props.put(REBLANCE_MAX_RETRIES, getKafkaConsumerConfig().getRebalance_max_retries());
        props.put(AUTO_OFFSET_RESET, getKafkaConsumerConfig().getAuto_offset_reset());

        return new ConsumerConfig(props);
    }

    public abstract KafkaConsumerConfig getKafkaConsumerConfig();

}
