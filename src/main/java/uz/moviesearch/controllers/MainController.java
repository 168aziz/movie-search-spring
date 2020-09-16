package uz.moviesearch.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uz.moviesearch.models.AbstractMovie;
import uz.moviesearch.service.PopularService;

import java.util.List;

@Controller
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class MainController {

    private PopularService service;

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("popularMovies", service.getPopular());
        return "index";
    }
}
