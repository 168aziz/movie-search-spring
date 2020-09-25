package uz.moviesearch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class PersonService extends AbstractService {

    public PersonService(ParseService service) {
        super(service);
    }

    public Optional<Person> getInfo(long id) {
        List<NameValuePair> params = ImmutableList.of(new BasicNameValuePair("person_id", id + ""));
        String path = "/person/" + id;

        return service.parsePerson(path, params).map(result -> {
            result.setExternal_ids(getExternal_IDs(path, params));
            result.setCredits(getCredits(path, params));
            result.setImages(getImages(path, params));
            return result;
        });
    }

    private Credits getCredits(String path, List<NameValuePair> params) {
        path += "/combined_credits";
        return service.parse(path, params, Credits.class).orElse(new Credits());
    }

    private External_ID getExternal_IDs(String path, List<NameValuePair> params) {
        path += "/external_ids";
        return service.parseExternal_IDs(path, params).orElse(new External_ID());
    }

    private Images getImages(String path, List<NameValuePair> params) {
        path += "/images";
        return service.parseImages(path, params).orElse(new Images());
    }
}
