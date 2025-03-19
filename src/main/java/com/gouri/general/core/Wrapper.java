package com.gouri.general.core;

import com.gouri.general.model.NewsResponse;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Component
public class Wrapper {

    @Value("${news.api.key}")
    private String SECRET_KEY;

    @Value("${news.api.url}")
    private String URL;

    private final RestTemplate restTemplate;

    public Wrapper(){
        this.restTemplate = new RestTemplate();
    }

    @PostConstruct
    public void init() {
        if (URL == null || URL.isEmpty()) {
            throw new IllegalStateException("Base URL is not set. Check application properties.");
        }
    }

    public NewsResponse fetchNews(String query){
        String url = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("apiKey", SECRET_KEY)
                .queryParam("q", query)
                .build()
                .toUriString();

        return restTemplate.getForObject(url, NewsResponse.class);
    }

}
