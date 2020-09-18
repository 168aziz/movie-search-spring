package uz.moviesearch.service;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import uz.moviesearch.logger.LoggerInstance;

@AllArgsConstructor
public class AbstractService {

    protected ParseService service;

    protected static Logger logger = LoggerInstance.getLogger(AbstractService.class);


}
