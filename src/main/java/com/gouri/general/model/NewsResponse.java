package com.gouri.general.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Data
public class NewsResponse {

    private String status;
    private int totalResults;
    private List<Articles> articles;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NewsResponse that)) return false;
        return totalResults == that.totalResults && Objects.equals(status, that.status) && Objects.equals(articles, that.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, totalResults, articles);
    }

    @Override
    public String toString() {
        return "NewsResponse{" +
                "status='" + status + '\'' +
                ", totalResults=" + totalResults +
                ", articles=" + articles +
                '}';
    }
}
