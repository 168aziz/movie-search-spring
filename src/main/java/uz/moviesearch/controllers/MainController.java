package uz.moviesearch.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.moviesearch.models.*;
import uz.moviesearch.service.PopularService;
import uz.moviesearch.service.SearchService;

import java.util.Collections;
import java.util.List;

@Controller
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class MainController {

    private final PopularService popularService;
    private final SearchService searchService;

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("popularMovies", popularService.getPopular(Movie.class));
        final List<Scene> popular = popularService.getPopular(TVShow.class);
        System.out.println(popular);
        model.addAttribute("popularTVShows", popular);
        return "index";
    }

    @PostMapping(value = "/search")
    public String searchPage(@RequestParam("search") String query,
                             @RequestParam(value = "page", required = false, defaultValue = "1") long page,
                             Model model) {

        ResultOfParse<Scene> movies = searchService.searchScene(query, page, Movie.class).orElse(new ResultOfParse<>());
        ResultOfParse<Scene> tvShows = searchService.searchScene(query, page, TVShow.class).orElse(new ResultOfParse<>());
        ResultOfParse<Person> people = searchService.searchPerson(query, page).orElse(new ResultOfParse<>());

        model.addAttribute("movies", movies)
                .addAttribute("tvShows", tvShows)
                .addAttribute("people", people);
        return "search";
    }


}
