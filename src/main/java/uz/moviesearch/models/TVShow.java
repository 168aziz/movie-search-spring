package uz.moviesearch.models;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Data
@Setter(onMethod=@__({@Autowired}))
@EqualsAndHashCode(callSuper = true)
@Component
@Scope("prototype")
public class TVShow extends AbstractMovie {

    private LocalDate first_air_date;
    private LocalDate last_air_date;
    private List<LocalTime> episode_runtime;
    private int number_of_episodes;
    private int number_of_seasons;
    //TODO создать сущность Season и Episodes
    private List<AbstractMovie> seasons;


}


