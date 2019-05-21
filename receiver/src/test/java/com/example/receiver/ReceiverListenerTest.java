package com.example.receiver;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = ReceiverListener.class)
public class ReceiverListenerTest {

    @Autowired
    Sink sink;

    @Rule
    public OutputCapture capture = new OutputCapture();

    @Mock
    SomeServiceA serviceA = new SomeServiceA(new SomeServiceB(new MessageDto()));

    @InjectMocks
    ReceiverListener receiverListener = new ReceiverListener();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.doNothing().when(serviceA).generateMessage(Mockito.anyString());
    }

    @Test
    public void receiveMessageTest() {
        Message<String> payload = new GenericMessage<>("hello");
        sink.input().send(payload);
    }
}
