package uz.moviesearch.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class MovieService {

    private final ReadFromTMDBService readFromTMDBService;


}
