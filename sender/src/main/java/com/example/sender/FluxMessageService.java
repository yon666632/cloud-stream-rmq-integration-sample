package com.example.sender;

import org.reactivestreams.Publisher;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.reactive.StreamEmitter;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
@Profile("flux")
public class FluxMessageService {

    @StreamEmitter
    @Output(Source.OUTPUT)
    public Publisher<Message<String>> send() {
        return IntegrationFlows.from(() ->
            new GenericMessage<>("hello"),
                e -> e.poller(p -> p.fixedDelay(5))).toReactivePublisher();
    }
}
