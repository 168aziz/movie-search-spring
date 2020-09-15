package uz.moviesearch.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@Setter(onMethod=@__({@Autowired}))
@EqualsAndHashCode(callSuper = true)
@Component
@Scope("prototype")
public class Movie extends  AbstractMovie {

    private LocalDate release_date;
    private int budget;
    private int revenue;
    private LocalTime runtime;


}
