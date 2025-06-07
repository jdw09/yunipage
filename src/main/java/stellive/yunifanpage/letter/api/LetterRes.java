package stellive.yunifanpage.letter.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stellive.yunifanpage.letter.service.LetterService;
import stellive.yunifanpage.letter.dto.Letter;

@RestController
@RequiredArgsConstructor
@RequestMapping("/letter")
public class LetterRes {

    private final LetterService letterService;

    @PostMapping("/post")
    public void sendLetter(@RequestBody Letter letter) {
        letterService.addLetter(letter.getBody());
    }
}
