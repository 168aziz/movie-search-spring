package uz.moviesearch.models;


import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Builder
@Setter(onMethod=@__({@Autowired}))
@ToString(of = "credit_id")
@Component
@Scope("prototype")
public class Credits{

    private int cast_id;
    private String character;
    private int credit_id;
}
