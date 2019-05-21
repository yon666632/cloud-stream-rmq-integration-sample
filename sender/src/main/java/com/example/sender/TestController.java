package com.example.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("flux")
public class TestController {

    @Autowired
    FluxMessageService service;

    @GetMapping(value = "/send")
    public void send() {
        service.send();
    }
}
