package uz.moviesearch.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(of = {"cast_id", "id", "character"})
public class Cast {

    private int cast_id;
    private String character;
    private String credit_id;
    private Gender gender;
    private long id;
    private String name;
    private String profile_path;
}
