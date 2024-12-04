package com.bombo.template.multijava.time;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class TimeClient {

    private final WebClient webClient;

    public TimeClient(WebClient webClient) {
        this.webClient = webClient;
    }
}
