package uz.moviesearch.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {

    private String file_path;
    private int height;
    private int width;
}
