package uz.moviesearch.controllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import uz.moviesearch.models.Genre;
import uz.moviesearch.models.Movie;
import uz.moviesearch.service.MovieService;
import uz.moviesearch.service.ParseService;

import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class MovieInfoController {

    private final MovieService service;


    @GetMapping("/movie/{id}")
    public String getMovie(@PathVariable("id") long id, Model model) {
        return service.getInfo("/movie", id).map(result -> {
            Movie movie = (Movie) result;
            model.addAttribute("movie", movie)
                    .addAttribute("year", movie.getRelease_date().getYear())
                    .addAttribute("date", movie.getRelease_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                    .addAttribute("runtime", movie.getRuntime().format(DateTimeFormatter.ofPattern("hh ч mm м")))
                    .addAttribute("revenue", String.format("%,d", movie.getRevenue()))
                    .addAttribute("budget", String.format("%,d", movie.getBudget()));

            String genres = movie.getGenres().stream().map(Genre::getName).collect(Collectors.joining(", "));
            model.addAttribute("genres", genres);
            return "movie-info";
        }).orElseGet(() -> "redirect:404.html");
    }


}
