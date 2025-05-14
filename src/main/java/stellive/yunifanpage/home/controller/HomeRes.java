package stellive.yunifanpage.home.controller;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import stellive.yunifanpage.home.dto.Books;
import stellive.yunifanpage.home.model.GestBookModel;
import stellive.yunifanpage.home.service.GestBookService;
import stellive.yunifanpage.home.service.HomeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeRes {

    private final GestBookService gestBookService;

    @GetMapping("/getAll")
    public List<GestBookModel> getAllBooks() {
        return gestBookService.getContent();
    }

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
