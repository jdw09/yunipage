package stellive.yunifanpage.letter.service;

import org.springframework.stereotype.Service;
import stellive.yunifanpage.letter.model.LetterModel;
import stellive.yunifanpage.letter.repository.LetterRepository;

@Service
public class LetterService {

    private final LetterRepository letterRepository;

    public LetterService(LetterRepository letterRepository) { this.letterRepository = letterRepository; }

    public void addLetter(String content) {
        LetterModel letterModel = new LetterModel();
        letterModel.setContent(content);
        letterRepository.save(letterModel);
    }

}
