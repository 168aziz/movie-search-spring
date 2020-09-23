package uz.moviesearch.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(of = "id")
public class Credits {

    private long id;
    private List<Cast> cast;
    private List<Crew> crew;
}
