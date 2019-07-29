package com.gtja.ydpt.imei.androidId.kafka.consumer;

import com.gtja.ydpt.imei.androidId.service.CollectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import com.gtja.versiondesc.service.NewStockDetailsService;
//import com.ydpt.common.kafka.consumer.AbstractKafkaConsumer;
//import com.ydpt.common.kafka.consumer.KafkaConsumerConfig;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;

@Component
public class StockMessageConsumer extends AbstractKafkaConsumer {
	private static Logger logger = LoggerFactory.getLogger(StockMessageConsumer.class);

	@Autowired
	StockMessageConsumerConfig stockMessageConsumerConfig;
	@Autowired
	CollectService collectService;

//	@Autowired
//	private NewStockDetailsService newStockDetailsService;

	@Override
	public void doBusiness(KafkaStream<byte[], byte[]> stream) {
		ConsumerIterator<byte[], byte[]> it = stream.iterator();

		while (it.hasNext()) {
			
			try {
				String stockDetail = new String(it.next().message());
				//向备份库中插入数据..

				logger.info(stockDetail);
				//逻辑业务
				System.out.println("consumer doBusiness before");
				collectService.addCollect(stockDetail);
				System.out.println("consumer doBusiness after");
				//newStockDetailsService.insertToBackup(stockDetail);
			} catch (Exception e) {
				logger.error("接收kafka信息入库失败, msg={}, cause={}, stack={}",
						new Object[] { e.getMessage(), e.getCause(), e.getStackTrace() });
			}
		}
	}

	@Override
	public KafkaConsumerConfig getKafkaConsumerConfig() {
		return stockMessageConsumerConfig;
	}

}
