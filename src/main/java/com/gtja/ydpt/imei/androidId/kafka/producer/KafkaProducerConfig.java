package com.gtja.ydpt.imei.androidId.kafka.producer;

import lombok.Data;

/**
 * 。。Created by meikebo on 2016/8/11.
 */
@Data
public class KafkaProducerConfig {

    private String bootstrapServers;
    private String topic;
    private String acks;
    private int retries;
    private int batchSize;
    private int lingerMs;
    private int bufferMemory;
    private String keySerializer;
    private String valueSerializer;
}
