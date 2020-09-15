package uz.moviesearch.models;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@Builder
@Setter(onMethod=@__({@Autowired}))
@Component
@Scope("prototype")
public class Person {

    private LocalDate birthday;
    private String known_for_department;
    private LocalDate deathday;
    private long id;
    private String name;
    private List<String> also_known_as;
    private String gender;
    private String biography;
    private String place_of_birth;
    private String profile_path;
    private Map<String, AbstractMovie> movieList;
    private double popularity;
    private String imdb_id;
    private String homepage;
    private Map<String, Object> external_ids;



}
