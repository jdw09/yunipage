package stellive.yunifanpage.letter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stellive.yunifanpage.letter.model.LetterModel;

@Repository
public interface LetterRepository extends JpaRepository<LetterModel, Long> {
}
