package uz.moviesearch.controllers;


import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.moviesearch.models.*;
import uz.moviesearch.service.ReadFromTMDBService;
import uz.moviesearch.service.SearchService;

import java.util.Collections;

@AllArgsConstructor(onConstructor = @__({@Autowired}))
@Controller
public class SearchController {

    private final SearchService searchService;


    @GetMapping("/upload-movie")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String uploadMovie(@RequestParam("search") String query,
                              @RequestParam(value = "page") long page,
                              @RequestParam("type") String type,
                              Model model) {
        String path = "/search" + (type.equals("movie") ? "/movie" : "/tv");
        ResultOfParse<Scene> sceneResultOfParse = searchService.searchScene(query, page, Movie.class).orElse(new ResultOfParse<>());
        model.addAttribute("movies", sceneResultOfParse);
        return "movie";
    }

}