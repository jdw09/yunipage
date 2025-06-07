package stellive.yunifanpage.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stellive.yunifanpage.home.model.GuestBookModel;

@Repository
public interface GuestBookRepository extends JpaRepository<GuestBookModel, Long> {
}
