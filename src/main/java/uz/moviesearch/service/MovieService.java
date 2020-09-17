package uz.moviesearch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService extends AbstractService {


    public MovieService(ReadFromTMDBService readFromTMDBService, ObjectMapper mapper) {
        super(readFromTMDBService, mapper);
    }

}
