package stellive.yunifanpage.viewController;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import stellive.yunifanpage.home.model.GuestBookModel;
import stellive.yunifanpage.home.service.GuestBookService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@SuppressWarnings("ALL")
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final RestTemplate restTemplate;
    private final GuestBookService guestBookService;

    @GetMapping("/")
    public String home(Model model) {
        String debut = getYuniDebut();
        List<GuestBookModel> content = guestBookService.getContent();

        model.addAttribute("yunidebut", debut);
        model.addAttribute("bookContent", content);
        return "home";
    }

//    @GetMapping("/legend")
//    public String legend() {
//        return "legend";
//    }

    private String getYuniDebut() {
        LocalDate debutDate = LocalDate.of(2023, 1, 8);
        LocalDate today = LocalDate.now();
        long days = ChronoUnit.DAYS.between(debutDate, today);
        return String.valueOf(days);
    }


}
