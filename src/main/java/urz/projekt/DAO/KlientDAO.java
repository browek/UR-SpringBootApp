package urz.projekt.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import urz.projekt.model.Klient;

@Repository
public interface KlientDAO extends JpaRepository<Klient, Long> {
	Klient findKlientByPesel(long pesel);
}
