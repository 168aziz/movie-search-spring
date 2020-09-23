package uz.moviesearch.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true, of = "")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TVShow extends Scene {


    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate first_air_date;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate last_air_date;
    private List<LocalTime> episode_runtime;
    private int number_of_episodes;
    private int number_of_seasons;
    //TODO создать сущность Season и Episodes
//    private List<Scene> seasons;


    @JsonProperty("original_name")
    @Override
    public String getOriginal_title() {
        return super.getOriginal_title();
    }

    @JsonProperty("name")
    @Override
    public String getTitle() {
        return super.getTitle();
    }
}


