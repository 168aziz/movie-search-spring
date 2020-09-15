package uz.moviesearch.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


public class LoggerInstance {

    private static Map<String, Logger> map;

    private LoggerInstance() {
    }

    public static Logger getLogger(Class<?> clazz) {
        if (map == null) map = new HashMap<>();
        if (map.get(clazz.getName()) == null) map.put(clazz.getName(), LogManager.getLogger(clazz));
        return map.get(clazz.getName());
    }
}
