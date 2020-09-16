package uz.moviesearch.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@ToString(of = {"id", "original_title"})
public abstract class AbstractMovie {

    private double popularity;
    private long vote_count;
    private String poster_path;
    private long id;
    private String original_language;
    private String backdrop_path;
    private String original_title;
    private String title;
    private String vote_average;
    private String overview;
    private String homepage;
    private String status;
    private String tagline;
    private List<AbstractMovie> recommendations;
    private List<String> images;
    private List<String> videos;
    private List<Person> credits;
    private List<Long> genre_ids;
    private Map<String, Object> external_ids;


}
