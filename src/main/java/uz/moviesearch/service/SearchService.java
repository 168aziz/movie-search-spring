package uz.moviesearch.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import uz.moviesearch.models.Movie;
import uz.moviesearch.models.Person;
import uz.moviesearch.models.ResultOfParse;
import uz.moviesearch.models.Scene;

import java.util.List;
import java.util.Optional;

@Service
@Scope("prototype")
public class SearchService extends AbstractService {

    @Autowired
    public SearchService(ParseService service) {
        super(service);
    }

    public Optional<ResultOfParse<Scene>> searchScene(String query, long page, Class<?> clazz) {
        String path = "/search" + (clazz.equals(Movie.class) ? "/movie" : "/tv");
        return service.parse(new ResultOfParse<>(), path, params(query, page), clazz);
    }

    public Optional<ResultOfParse<Person>> searchPerson(String query, long page) {
        String path = "/search/person";

        return service.parse(new ResultOfParse<>(), path, params(query, page), Person.class);
    }

    private List<NameValuePair> params(String query, long page) {
        return ImmutableList.of(new BasicNameValuePair("query", query),
                new BasicNameValuePair("page", page + ""));
    }

}
