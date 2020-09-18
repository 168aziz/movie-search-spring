package uz.moviesearch.service;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import uz.moviesearch.models.Scene;
import uz.moviesearch.models.Movie;
import uz.moviesearch.models.ResultOfParse;

import java.util.Collections;
import java.util.List;

import static java.util.Comparator.*;

@Service
@Scope("prototype")
public class PopularService extends AbstractService {


    public PopularService(ParseService service) {
        super(service);
    }

    public List<Scene> getPopular(Class<?> clazz) {

        String path = (clazz.equals(Movie.class) ? "/movie" : "/tv") + "/popular";

        return service.parse(new ResultOfParse<Scene>(), path, Collections.emptyList(), clazz).map(result -> {
            result.getResults().sort(comparing(Scene::getPopularity, reverseOrder()));
            return result.getResults().subList(0, 6);
        }).orElse(Collections.emptyList());
    }

}
