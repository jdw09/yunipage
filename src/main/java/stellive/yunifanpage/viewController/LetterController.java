package stellive.yunifanpage.viewController;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import stellive.yunifanpage.letter.service.LetterService;

@Controller
@RequiredArgsConstructor
public class LetterController {
    private final LetterService letterService;
    private String content;

    @PostMapping("/submitLetter")
    public String addLetter(@RequestParam("content") String content) {
        this.content = content;
        if (content == null || content.isEmpty()) {
            return "isSucceed/LetterNotSucceed";
        }
        letterService.addLetter(content);
        return "isSucceed/LetterSucceed";
    }

    @GetMapping("/writeLetter")
    public String writeLetter() {
        return "writeLetter";
    }
}
