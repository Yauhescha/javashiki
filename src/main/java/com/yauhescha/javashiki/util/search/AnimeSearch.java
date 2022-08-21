package com.yauhescha.javashiki.util.search;

import lombok.Builder;

import javax.validation.constraints.Size;

@Builder
public class AnimeSearch {

    @Size(min = 1, max = 100000)
    private Integer page;

    @Size(min = 1, max = 50)
    private Integer limit;

    private SearchOrderType order;

    private SearchOrderKind kind;

    private SearchOrderStatus status;

    private String season;

    @Size(min = 1, max = 10)
    private Float score;

    private SearchOrderDuration duration;

    private SearchOrderRating rating;

    private String genre;

    private String studio;

    private String franchise;

    private Boolean censored;

    private SearchOrderListStatus mylist;

    private String ids;

    private String exclude_ids;

    // search by name
    private String search;

}
