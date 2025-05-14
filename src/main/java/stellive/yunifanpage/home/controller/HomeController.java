package stellive.yunifanpage.home.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import stellive.yunifanpage.home.model.GestBookModel;

import java.util.List;

@SuppressWarnings("ALL")
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final RestTemplate restTemplate;

    @GetMapping("/")
    public String home(Model model) {
        String debut = restTemplate.getForObject("http://127.0.0.1:8080/home/getDebut", String.class);
        List<GestBookModel> content = restTemplate.getForObject("http://127.0.0.1:8080/home/getAll", List.class);
        model.addAttribute("yunidebut", debut);
        model.addAttribute("bookContent", content);
        return "home";
    }

    @GetMapping("/mobile")
    public String mobile(Model model) {
        String debut = restTemplate.getForObject("http://127.0.0.1:8080/home/getDebut", String.class);
        List<GestBookModel> content = restTemplate.getForObject("http://127.0.0.1:8080/home/getAll", List.class);
        model.addAttribute("yunidebut", debut);
        model.addAttribute("bookContent", content);
        return "mobile/home-mobile";
    }

    @GetMapping("/legend")
    public String legend() {
        return "legend";
    }
}
