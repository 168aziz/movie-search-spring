package uz.moviesearch.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class External_ID {

    private String id;
    private String imdb_id;
    private String facebook_id;
    private String instagram_id;
    private String twitter_id;
}
