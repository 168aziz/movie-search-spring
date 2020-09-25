package uz.moviesearch.service;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PingService {


    @Scheduled(fixedRate = 1200000)
    public void pingGoogle() {
        HttpGet getRequest = new HttpGet("https://www.google.com/");
        getRequest.addHeader("Content-Type", "application/json; charset=utf-8");
        getRequest.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36");
        getRequest.addHeader("Cache-Control", "max-age=21600");


        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(getRequest)) {
            System.out.println(response.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
