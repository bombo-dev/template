package com.bombo.template.multijava;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
public class WebClientConfiguration implements WebFluxConfigurer {

    private static final int MS_TO_SECONDS = 1000;

    @Bean
    public WebClient webClient() {
        HttpClient httpClient = HttpClient.create()
                .resolver(DefaultAddressResolverGroup.INSTANCE)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10 * MS_TO_SECONDS)
                .responseTimeout(Duration.ofMillis(60 * MS_TO_SECONDS))
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(60 * MS_TO_SECONDS, TimeUnit.MILLISECONDS))
                            .addHandlerLast(new WriteTimeoutHandler(60 * MS_TO_SECONDS, TimeUnit.MILLISECONDS));
                });

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        DateTimeFormatterRegistrar dateTimeFormatterRegistrar = new DateTimeFormatterRegistrar();
        dateTimeFormatterRegistrar.setUseIsoFormat(true);
        dateTimeFormatterRegistrar.registerFormatters(registry);
    }
}
