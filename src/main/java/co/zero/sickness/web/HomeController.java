package co.zero.sickness.web;

import co.zero.sickness.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String getHome(Model model) {
        List<Person> people = List.of(new Person("1", "Hernan"), new Person("2", "Natha"));
        model.addAttribute("people", people);
        return "home";
    }
}
