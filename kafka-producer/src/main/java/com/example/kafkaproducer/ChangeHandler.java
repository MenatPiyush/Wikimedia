package com.example.kafkaproducer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;

public class ChangeHandler implements EventHandler {

    private static final Logger logger = LoggerFactory.getLogger(ChangeHandler.class);

    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;

    public ChangeHandler(KafkaTemplate<String,String> kafkaTemplate, String topic){
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception{
       logger.info(String.format("event data -> %s", messageEvent.getData()));
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {
        logger.info(String.format("Error while receiving data from wikimedia"));
    }

}
