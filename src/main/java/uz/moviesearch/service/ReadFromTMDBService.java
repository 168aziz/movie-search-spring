package uz.moviesearch.service;


import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;
import static uz.moviesearch.logger.LoggerInstance.getLogger;

@Service
@Scope("prototype")
public class ReadFromTMDBService {

    private static Logger logger = getLogger(ReadFromTMDBService.class);

    @Value("${app.basicPath}")
    private String basicPath;

    @Value("${app.key}")
    private String api_key;

    @Value("${app.language}")
    private String language;

    private final String EMPTY_STRING = "";


    public String read(String path, List<NameValuePair> parameters) {

        return builder(path, parameters).map(url -> {

            try {
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36");
                connection.setRequestProperty("Cache-Control", "public, max-age=21600");
                connection.connect();

                if (connection.getResponseCode() == 200) {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), UTF_8))) {
                        return reader.lines().collect(Collectors.joining());
                    } catch (IOException e) {
                        logger.warn("Error reading JSON", e);
                    }
                }
            } catch (IOException e) {
                logger.warn("Connection error", e);
            }
            return EMPTY_STRING;
        }).orElse(EMPTY_STRING);

    }

    private Optional<URL> builder(String path, List<NameValuePair> parameters) {
        logger = getLogger(ParsingJSON.class);
        URL build = null;
        try {
            URIBuilder builder = new URIBuilder(basicPath);
            builder.setPath("3" + path)
                    .addParameter("language", language)
                    .addParameter("api_key", api_key);
            if (parameters.isEmpty())
                builder.addParameters(parameters);
            build = builder.build().toURL();
        } catch (URISyntaxException e) {
            logger.warn("Ошибка в билдере URL", e);
        } catch (MalformedURLException e) {
            logger.warn("Ошибка в конвертировании", e);
        }
        return Optional.ofNullable(build);
    }
}
