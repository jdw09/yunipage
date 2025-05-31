package stellive.yunifanpage.home.api;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import stellive.yunifanpage.home.dto.Books;
import stellive.yunifanpage.home.service.GestBookService;
import stellive.yunifanpage.home.service.HomeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeRes {

    private final GestBookService gestBookService;

    @GetMapping("/getDebut")
    public String getDebut() {
        return HomeService.getYuniDebut();
    }

    @PostMapping("/post")
    public void postBooks(@RequestBody Books books) {
        String[] book = new String[] {books.getName(), books.getBody()};
        gestBookService.addGestBook(book);
    }
}
