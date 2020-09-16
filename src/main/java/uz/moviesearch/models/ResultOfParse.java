package uz.moviesearch.models;

import lombok.Data;


import java.util.List;


@Data
public class ResultOfParse<T> {

    private int page;
    private int total_pages;
    private int total_results;

    private List<T> results;


}
