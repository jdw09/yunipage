package stellive.yunifanpage.home.service;

import org.springframework.stereotype.Service;
import stellive.yunifanpage.home.model.GuestBookModel;
import stellive.yunifanpage.home.repository.GuestBookRepository;

import java.util.List;

@Service
public class GuestBookService {

    private final GuestBookRepository guestBookRepository;



    public GuestBookService(GuestBookRepository gestBookRepository) { this.guestBookRepository = gestBookRepository; }

    public List<GuestBookModel> getContent() {
        System.out.println(guestBookRepository.findAll());
        return guestBookRepository.findAll();
    }

    public void addGuestBook(String[] content) {
        GuestBookModel guestBookModel = new GuestBookModel();
        guestBookModel.setContent(content[0]);
        guestBookModel.setName(content[1]);
        guestBookRepository.save(guestBookModel);
    }

}
