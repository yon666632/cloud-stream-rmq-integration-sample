package com.example.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class ReceiverListener {

    @Autowired
    private SomeServiceA serviceA;

    @StreamListener(Sink.INPUT)
    public void receive(String msg) {
        serviceA.generateMessage(msg);
    }
}
