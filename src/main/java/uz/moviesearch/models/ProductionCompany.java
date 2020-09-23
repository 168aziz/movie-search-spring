package uz.moviesearch.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import org.json.JSONPropertyIgnore;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(of = {"id", "name"})
public class ProductionCompany {

    private long id;
    private String logo_path;
    private String name;
    private String origin_country;
}
