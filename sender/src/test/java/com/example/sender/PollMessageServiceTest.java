package com.example.sender;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PollMessageServiceTest {

    @Autowired
    PollMessageService service;

    @Autowired
    Source source;

    @Autowired
    MessageCollector collector;

    @Test
    public void sendTest() {
        service.send();
        Message<String> sendMessage =
                (Message<String>) collector.forChannel(source.output()).poll();
        Assertions.assertThat(sendMessage.getPayload()).isEqualTo("hello");
    }
}
