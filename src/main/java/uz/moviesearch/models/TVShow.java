package uz.moviesearch.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true, of = "")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TVShow extends AbstractMovie {

    private LocalDate first_air_date;
    private LocalDate last_air_date;
    private List<LocalTime> episode_runtime;
    private int number_of_episodes;
    private int number_of_seasons;
    //TODO создать сущность Season и Episodes
    private List<AbstractMovie> seasons;


}


