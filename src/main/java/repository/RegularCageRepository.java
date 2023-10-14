package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Entities.RegularCage;

public interface RegularCageRepository extends JpaRepository<RegularCage, Integer> {
	@Query("SELECT * FROM production.regular_cages")
	public List<RegularCage> findAll();
	@Query("SELECT * FROM production.regular_cages WHERE birdtype_id = :birdtypeId")
	public List<RegularCage> findAllByBirdtype(@Param("birdtypeId") int birdtypeId);
}
