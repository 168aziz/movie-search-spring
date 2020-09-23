package uz.moviesearch.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Video {

    private String id;
    private String key;
    private String name;
    private String site;
    private long size;
    private String type;
}
