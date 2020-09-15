package uz.moviesearch.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;


@Data
@Builder
@Setter(onMethod=@__({@Autowired}))
@Component
@Scope("prototype")
public class ResultOfParse<E> {
    private int current_page;
    private int total_page;
    private List<E> result;


}
