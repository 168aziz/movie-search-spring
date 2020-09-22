package uz.moviesearch.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Images {

    private List<Image> backdrops;
    private List<Image> posters;
}
