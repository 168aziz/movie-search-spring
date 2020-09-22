package uz.moviesearch.service;

import com.google.common.collect.ImmutableList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import uz.moviesearch.models.*;

import java.util.List;
import java.util.Optional;

@Service
@Scope("prototype")
public class MovieService extends AbstractService {

    public MovieService(ParseService service) {
        super(service);
    }


    public Optional<Scene> getInfo(String basicPath, long id) {
        String path = basicPath + "/" + id;

        Class<?> clazz;
        if (basicPath.endsWith("movie"))
            clazz = Movie.class;
        else
            clazz = TVShow.class;

        List<NameValuePair> params = ImmutableList.of(new BasicNameValuePair("movie_id", id + ""));

        return service.parseScene(path, params, clazz).map(result -> {

            result.setCredits(getCredits(path, params));
            result.setRecommendations(getRecommendations(path, params, clazz));
            result.setExternal_id(getExternal_IDs(path, params));
            result.setImages(getImages(path, params));
            return result;
        });
    }


    private Credits getCredits(String path, List<NameValuePair> params) {
        path += "/credits";
        return service.parse(path, params, Credits.class).orElse(new Credits());
    }

    private External_ID getExternal_IDs(String path, List<NameValuePair> params) {
        path += "/external_ids";
        return service.parseExternal_IDs(path, params).orElse(new External_ID());
    }

    private ResultOfParse<Scene> getRecommendations(String path, List<NameValuePair> params, Class<?> clazz) {
        path += "/recommendations";
        return service.parse(new ResultOfParse<Scene>(), path, params, clazz).orElse(new ResultOfParse<>());
    }

    private Images getImages(String path, List<NameValuePair> params) {
        path += "/recommendations";
        return service.parseImages(path, params).orElse(new Images());
    }

}
