package uz.moviesearch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class MovieService extends AbstractParsingService {


    public MovieService(ReadFromTMDBService readFromTMDBService, ObjectMapper mapper) {
        super(readFromTMDBService, mapper);
    }




}
