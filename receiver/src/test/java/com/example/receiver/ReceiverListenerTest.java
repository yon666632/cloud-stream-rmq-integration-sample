package com.example.receiver;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ReceiverListenerTest {

    @Autowired
    Sink sink;

    @Rule
    public OutputCapture capture = new OutputCapture();

    @Test
    public void receiveMessageTest() {
        Message<String> payload = new GenericMessage<>("hello");
        sink.input().send(payload);
        Assertions.assertThat(capture.toString()).isEqualTo("hello" + System.lineSeparator());
    }
}
