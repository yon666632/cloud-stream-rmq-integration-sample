package com.example.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
@EnableBinding(Source.class)
public class SendMessageService {

    @Autowired
    private Source source;

    @Scheduled(fixedDelay = 1000L)
    public void send() {
        source.output().send(MessageBuilder.createMessage(
                "hello",
                new MessageHeaders(
                        Collections.singletonMap(MessageHeaders.CONTENT_TYPE, "text/plain")
                )
        ));
    }
}
