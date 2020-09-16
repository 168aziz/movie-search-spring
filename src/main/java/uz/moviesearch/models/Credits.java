package uz.moviesearch.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(of = "credit_id")
public class Credits{

    private int cast_id;
    private String character;
    private int credit_id;
}
