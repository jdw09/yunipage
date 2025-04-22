package stellive.yunifanpage.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stellive.yunifanpage.home.model.GestBookModel;
import stellive.yunifanpage.home.model.LetterModel;

@Repository
public interface LetterRepository extends JpaRepository<LetterModel, Long> {
}
