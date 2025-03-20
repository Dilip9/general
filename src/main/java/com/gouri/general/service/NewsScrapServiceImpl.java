package com.gouri.general.service;

import com.gouri.general.core.Wrapper;
import com.gouri.general.model.NewsResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewsScrapServiceImpl implements NewsScrapService {

    private final Wrapper wrapper;

    public NewsScrapServiceImpl(Wrapper wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public Optional<NewsResponse> scrapNewsDataBasedOnQuery(String query) {
        //NewsResponse newsResponse = wrapper.fetchNews(query);

        return Optional.ofNullable(wrapper.fetchNews(query));

    }
}
