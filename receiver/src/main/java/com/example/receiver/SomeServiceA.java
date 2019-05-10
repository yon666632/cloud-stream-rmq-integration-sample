package com.example.receiver;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SomeServiceA {
    private final SomeServiceB serviceB;

    public void generateMessage(String receivedMessage) {
        System.out.println(serviceB.getMessage().getMessage() + receivedMessage);
    }
}
