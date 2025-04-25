package stellive.yunifanpage.home.controller;

import org.apache.catalina.valves.rewrite.InternalRewriteMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import stellive.yunifanpage.home.model.GestBookModel;
import stellive.yunifanpage.home.repository.GestBookRepository;
import stellive.yunifanpage.home.service.GestBookService;
import stellive.yunifanpage.home.service.HomeService;

import java.util.List;

@Controller
public class HomeController {

    private final GestBookService gestBookService;
    private String content;
    private String name;

    public HomeController(GestBookService gestBookService, GestBookRepository gestBookRepository) { this.gestBookService = gestBookService; }

    @GetMapping("/")
    public String home(Model model) {
        String yunidebut = HomeService.getYuniDebut();
        List<GestBookModel> content = gestBookService.getContent();
        model.addAttribute("yunidebut", yunidebut);
        model.addAttribute("bookContent", content);
        return "home";
    }

    @GetMapping("/mobile")
    public String mobile(Model model) {
        String yunidebut = HomeService.getYuniDebut();
        List<GestBookModel> content = gestBookService.getContent();
        model.addAttribute("yunidebut", yunidebut);
        model.addAttribute("bookContent", content);
        return "mobile/home-mobile";
    }

    @PostMapping("/addGestBook")
    public String addGestBook(@RequestParam String content, String name) {
        this.content = content;
        this.name = name;
        String[] bookContent = {content, name};
        if (bookContent[0] == null || bookContent[1] == null || bookContent[0].isEmpty() || bookContent[1].isEmpty()) {
            return "isSucceed/gestBookNotSucceed";
        }
        gestBookService.addGestBook(bookContent);
        return "isSucceed/gestBookSucceed";
    }

    @GetMapping("/legend")
    public String legend() {
        return "legend";
    }
}
