package com.gtja.ydpt.imei.androidId.kafka.consumer;

import lombok.Data;

/**
 * Created by ˙oulei on 2016/8/11.
 */
@Data
public class KafkaConsumerConfig {

    private String zookeeper_connect;
    private String group_id;
    private String topic;
    private String auto_commit_enable;
    private String auto_commit_interval_ms;
    private String rebalance_max_retries;
    private String auto_offset_reset;
    private String client_num;

}
