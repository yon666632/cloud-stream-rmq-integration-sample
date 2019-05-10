package com.example.receiver;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SomeServiceB {
    private final MessageDto messageDto;

    public MessageDto getMessage() {
        return new MessageDto();
    }
}
