package com.gouri.general.service;

import com.gouri.general.core.Wrapper;
import com.gouri.general.model.NewsResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NewsScrapServiceImplTest {

    @Mock
    private Wrapper wrapper;
    @InjectMocks
    private NewsScrapServiceImpl newsScrapService;

    private String query = "India";

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void scrapNewsDataBasedOnQuery() {
        //Mock data.
        NewsResponse mockNewsResponse = new NewsResponse();
        when(wrapper.fetchNews(query)).thenReturn(mockNewsResponse);

        //call service method.
        Optional<NewsResponse> newsResponse = newsScrapService.scrapNewsDataBasedOnQuery(query);
        // Assertions
        assertTrue(newsResponse.isPresent());
        assertEquals(mockNewsResponse, newsResponse.get());


    }
}