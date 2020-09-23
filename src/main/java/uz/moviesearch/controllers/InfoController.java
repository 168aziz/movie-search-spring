package uz.moviesearch.controllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.moviesearch.models.Cast;
import uz.moviesearch.models.Genre;
import uz.moviesearch.models.Movie;
import uz.moviesearch.models.TVShow;
import uz.moviesearch.service.PersonService;
import uz.moviesearch.service.SceneService;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class InfoController {

    private final SceneService sceneService;
    private final PersonService personService;

    @GetMapping("/movie/{id}")
    public String getMovie(@PathVariable("id") long id, Model model) {
        return sceneService.getInfo("/movie", id).map(result -> {
            Movie movie = (Movie) result;
            model.addAttribute("movie", movie)
                    .addAttribute("path", "movie")
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


    @GetMapping("/tv/{id}")
    public String getTVShow(@PathVariable("id") long id, Model model) {
        return sceneService.getInfo("/tv", id).map(result -> {
            TVShow movie = (TVShow) result;
            model.addAttribute("movie", movie)
                    .addAttribute("path", "tv")
                    .addAttribute("year", movie.getFirst_air_date().getYear())
                    .addAttribute("date", movie.getFirst_air_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            String genres = movie.getGenres().stream().map(Genre::getName).collect(Collectors.joining(", "));
            model.addAttribute("genres", genres);
            return "movie-info";
        }).orElseGet(() -> "redirect:/");
    }

    @GetMapping("/person/{id}")
    public String getPerson(@PathVariable("id") long id, Model model) {
        return personService.getInfo(id).map(person -> {
//            person.getCredits().getCast().sort(Collections.reverseOrder(Comparator.comparing(Cast::getDate)));
            System.out.println(person.getCredits().getCast());

            person.getCredits().setCast(person.getCredits().getCast().stream().filter(cast -> cast.getDate() != null).collect(Collectors.toList()));
            person.getCredits().getCast().sort(Collections.reverseOrder(Comparator.comparing(Cast::getDate)));
            model.addAttribute("person", person)
                    .addAttribute("age", Period.between(person.getBirthday(), LocalDate.now()).getYears());
            return "person-info";
        }).orElseGet(() -> "redirect:/");
    }


}
