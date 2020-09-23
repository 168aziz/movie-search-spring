package uz.moviesearch.models;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(of = {"id", "original_title"})
public abstract class Scene {

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
    private List<Genre> genres;
    private String imbd_id;
    private List<ProductionCompany> production_companies;

    private Credits credits;
    private ResultOfParse<Scene> recommendations;
    private Images images;
    private List<Video> videos;
    private External_ID external_id;


}
