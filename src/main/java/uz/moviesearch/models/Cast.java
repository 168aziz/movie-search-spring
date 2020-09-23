package uz.moviesearch.models;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(of = {"cast_id", "id", "character", "date", "media_type"})
public class Cast extends Person {

    private int cast_id;
    private String character;
    private String credit_id;
    private String media_type;

    @JsonAlias(value = {"name", "title"})
    @JsonProperty(defaultValue = "")
    private String title;
    private String poster_path;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonAlias(value = {"first_air_date", "release_date"})
    private LocalDate date;


}
