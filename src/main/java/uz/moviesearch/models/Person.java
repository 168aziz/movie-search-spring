package uz.moviesearch.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@Builder
@ToString(of = {"id","name"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate deathday;
    private long id;
    private String name;
    private List<String> also_known_as;
    private String gender;
    private String biography;
    private String place_of_birth;
    private String profile_path;
    private String known_for_department;
    private double popularity;
    private String imdb_id;
    private String homepage;
    private Map<String, Object> external_ids;
    private Map<String, AbstractMovie> movieList;



}
