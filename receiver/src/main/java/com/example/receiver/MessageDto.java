package com.example.receiver;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class MessageDto {
    private String message = "hello ";
}
