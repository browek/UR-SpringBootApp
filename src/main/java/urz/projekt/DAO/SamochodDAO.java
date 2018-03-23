package urz.projekt.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import urz.projekt.model.Samochod;

@Repository
public interface SamochodDAO extends JpaRepository<Samochod, Long>{
}
