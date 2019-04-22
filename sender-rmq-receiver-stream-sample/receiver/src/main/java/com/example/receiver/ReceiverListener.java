package com.example.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class ReceiverListener {

    @StreamListener(Sink.INPUT)
    public void receive(String msg) {
        Logger logger = LoggerFactory.getLogger(ReceiverListener.class);
        logger.info(msg);
    }
}
