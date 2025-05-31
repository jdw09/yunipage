package stellive.yunifanpage.home.service;

import org.springframework.stereotype.Service;
import stellive.yunifanpage.home.model.GestBookModel;
import stellive.yunifanpage.home.repository.GestBookRepository;

import java.util.List;

@Service
public class GestBookService {

    private final GestBookRepository gestBookRepository;



    public GestBookService(GestBookRepository gestBookRepository) { this.gestBookRepository = gestBookRepository; }

    public List<GestBookModel> getContent() {
         return gestBookRepository.findAll();
    }

    public void addGestBook(String[] content) {
        GestBookModel gestBookModel = new GestBookModel();
        gestBookModel.setContent(content[0]);
        gestBookModel.setName(content[1]);
        gestBookRepository.save(gestBookModel);
    }

}
