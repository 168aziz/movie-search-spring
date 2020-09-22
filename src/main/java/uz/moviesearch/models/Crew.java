package uz.moviesearch.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(of = "id")
public class Crew {

    private String credit_id;
    private String department;
    private Gender gender;
    private long id;
    private String job;
    private String name;
    private String profile_path;
}
