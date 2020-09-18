package uz.moviesearch.service;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import uz.moviesearch.models.ResultOfParse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;

@Service
@Scope("prototype")
public class ParseService extends AbstractParsingService {


    @Autowired
    public ParseService(ReadFromTMDBService readFromTMDBService, ObjectMapper mapper) {
        super(readFromTMDBService, mapper);
    }

    public <T> Optional<ResultOfParse<T>> parse(ResultOfParse<T> result, String path, List<NameValuePair> parameters, Class<?> clazz) {
        String json = readFromTMDBService.read(path, parameters);
        if (json.isEmpty()) return Optional.empty();
        try {
            JavaType type = mapper.getTypeFactory().constructParametricType(ResultOfParse.class, clazz);
            result = mapper.readValue(json, type);

        } catch (IOException e) {
            logger.warn("Error reading JSON", e);
        }
        return Optional.ofNullable(result);
    }
}
