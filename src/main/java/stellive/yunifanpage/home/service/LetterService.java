package stellive.yunifanpage.home.service;

import org.springframework.stereotype.Service;
import stellive.yunifanpage.home.model.LetterModel;
import stellive.yunifanpage.home.repository.LetterRepository;

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
