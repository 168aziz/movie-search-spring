package uz.moviesearch.service;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import uz.moviesearch.logger.LoggerInstance;
import uz.moviesearch.models.AbstractMovie;
import uz.moviesearch.models.Movie;
import uz.moviesearch.models.ResultOfParse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;

@Service
@Scope("prototype")
public class PopularService extends AbstractService{



    public PopularService(ReadFromTMDBService readFromTMDBService, ObjectMapper mapper) {
        super(readFromTMDBService, mapper);
    }


    public List<AbstractMovie> getPopular(Class<?> clazz) {

        String path = clazz.equals(Movie.class) ? "/movie" : "/tv";
        String json = readFromTMDBService.read(path + "/popular", Collections.emptyList());
        if (json.isEmpty()) return Collections.emptyList();

        List<AbstractMovie> movies = new ArrayList<>();

        try {
            JavaType type = mapper.getTypeFactory().constructParametricType(ResultOfParse.class, clazz);
            ResultOfParse<AbstractMovie> resultOfParse = mapper.readValue(json, type);

            resultOfParse.getResults().sort(comparing(AbstractMovie::getPopularity, reverseOrder()));
            movies.addAll(resultOfParse.getResults().subList(0, 6));

        } catch (IOException e) {
            logger.warn("Error reading JSON", e);
        }

        return movies;
    }

}
