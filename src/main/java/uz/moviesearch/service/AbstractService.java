package uz.moviesearch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.moviesearch.logger.LoggerInstance;

@AllArgsConstructor(onConstructor = @__({@Autowired}))
public abstract class AbstractService {

    protected final ReadFromTMDBService readFromTMDBService;

    protected final ObjectMapper mapper;

    protected static Logger logger = LoggerInstance.getLogger(AbstractService.class);

}
