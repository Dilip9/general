package com.gouri.general.controller;

import com.gouri.general.model.NewsResponse;
import com.gouri.general.service.NewsScrapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/news")
public class NewsScrapController {

    private static final Logger logger = LoggerFactory.getLogger(NewsScrapController.class);

    private NewsScrapService newsScrapService;

    public NewsScrapController(NewsScrapService newsScrapService) {
        this.newsScrapService = newsScrapService;
    }

    @GetMapping(value = "/scrap", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NewsResponse> scrapNews(@RequestParam("query") String query){
        Optional<NewsResponse> newsResponse = newsScrapService.scrapNewsDataBasedOnQuery(query);
        return ResponseEntity.ok(newsResponse.get());
    }
}
