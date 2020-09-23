package uz.moviesearch.service;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import uz.moviesearch.models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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

    public Optional<Scene> parseScene(String path, List<NameValuePair> parameters, Class<?> clazz) {
        String json = readFromTMDBService.read(path, parameters);
        Scene result = null;
        if (json.isEmpty()) return Optional.empty();
        try {
            result = (Scene) mapper.readValue(json, clazz);

        } catch (IOException e) {
            logger.warn("Error reading JSON", e);
        }
        return Optional.ofNullable(result);
    }


    public Optional<Person> parsePerson(String path, List<NameValuePair> parameters) {
        String json = readFromTMDBService.read(path, parameters);
        Person person = null;
        if (json.isEmpty()) return Optional.empty();

        try {
            person = mapper.readValue(json, Person.class);
        } catch (IOException e) {
            logger.warn("Error reading JSON", e);
        }
        return Optional.ofNullable(person);
    }

    public Optional<External_ID> parseExternal_IDs(String path, List<NameValuePair> parameters) {
        String json = readFromTMDBService.read(path, parameters);
        External_ID result = null;
        if (json.isEmpty()) return Optional.empty();
        try {
            result = mapper.readValue(json, External_ID.class);

        } catch (IOException e) {
            logger.warn("Error reading JSON", e);
        }
        return Optional.ofNullable(result);
    }


    public Optional<Credits> parse(String path, List<NameValuePair> parameters, Class<?> clazz) {
        String json = readFromTMDBService.read(path, parameters);
        Credits result = null;
        if (json.isEmpty()) return Optional.empty();
        try {
            result = mapper.readValue(json, Credits.class);

        } catch (IOException e) {
            logger.warn("Error reading JSON", e);
        }
        return Optional.ofNullable(result);
    }


    public Optional<Images> parseImages(String path, List<NameValuePair> parameters) {
        List<NameValuePair> params = new ArrayList<>(parameters);
        params.add(new BasicNameValuePair("language", ""));
        String json = readFromTMDBService.read(path, params);
        Images result = null;
        if (json.isEmpty()) return Optional.empty();
        try {
            result = mapper.readValue(json, Images.class);

        } catch (IOException e) {
            logger.warn("Error reading JSON", e);
        }
        return Optional.ofNullable(result);
    }

    public List<Video> parseVideos(String path, List<NameValuePair> parameters) {
        List<NameValuePair> params = new ArrayList<>(parameters);
        String json = readFromTMDBService.read(path, params);
        params.add(new BasicNameValuePair("language", ""));
        String jsonDefault = readFromTMDBService.read(path, params);

        List<Video> list = null;
        try {
            Videos videos = mapper.readValue(json, Videos.class);
            Videos videosDef = mapper.readValue(jsonDefault, Videos.class);
            list = new ArrayList<>();
            if (videos.getResults() != null) list.addAll(videos.getResults());
            if (videosDef.getResults() != null) list.addAll(videosDef.getResults());

        } catch (IOException e) {
            logger.warn("Error reading JSON", e);
        }
        if (list != null && list.isEmpty()) return null;
        return list;
    }


}
