package stellive.yunifanpage.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stellive.yunifanpage.home.model.HomeModel;

@Repository
public interface HomeRepository extends JpaRepository<HomeModel, Long> {
}
