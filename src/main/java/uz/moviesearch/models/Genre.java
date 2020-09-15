package uz.moviesearch.models;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Setter(onMethod=@__({@Autowired}))
@Builder
@Component
@ToString(of = {"id","name"})
@Scope("prototype")
public class Genre {

    private int id;
    private String name;


}
