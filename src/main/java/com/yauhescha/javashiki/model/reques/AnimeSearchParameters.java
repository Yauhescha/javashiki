package com.yauhescha.javashiki.model.reques;

import com.yauhescha.javashiki.constant.search.SearchOrderDuration;
import com.yauhescha.javashiki.constant.search.SearchOrderKind;
import com.yauhescha.javashiki.constant.search.SearchOrderListStatus;
import com.yauhescha.javashiki.constant.search.SearchOrderRating;
import com.yauhescha.javashiki.constant.search.SearchOrderStatus;
import com.yauhescha.javashiki.constant.search.SearchOrderType;
import lombok.Builder;

import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

@Builder
public class AnimeSearchParameters {

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
    
    public Map<String, Object> getSearchParameters(){
        Map<String, Object> parameters = new HashMap<>();
        if(page!=null){
            parameters.put("page",page);
        }
        if(limit!=null){
            parameters.put("limit",limit);
        }
        if(order!=null){
            parameters.put("order",order);
        }
        if(kind!=null){
            parameters.put("kind",kind);
        }
        if(status!=null){
            parameters.put("status",status);
        }
        if(season!=null){
            parameters.put("season",season);
        }
        if(score!=null){
            parameters.put("score",score);
        }
        if(duration!=null){
            parameters.put("duration",duration);
        }
        if(rating!=null){
            parameters.put("rating",rating);
        }
        if(genre!=null){
            parameters.put("genre",genre);
        }
        if(studio!=null){
            parameters.put("studio",studio);
        }
        if(franchise!=null){
            parameters.put("franchise",franchise);
        }
        if(censored!=null){
            parameters.put("censored",censored);
        }
        if(mylist!=null){
            parameters.put("mylist",mylist);
        }
        if(ids!=null){
            parameters.put("ids",ids);
        }
        if(exclude_ids!=null){
            parameters.put("exclude_ids",exclude_ids);
        }
        if(search!=null){
            parameters.put("search",search);
        }
        return parameters;
    }

}
