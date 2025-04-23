package com.gouri.general.service;

import com.gouri.general.model.dto.NewsResponse;

import java.util.Optional;

public interface NewsScrapService {

    Optional<NewsResponse> scrapNewsDataBasedOnQuery(String query);
}
