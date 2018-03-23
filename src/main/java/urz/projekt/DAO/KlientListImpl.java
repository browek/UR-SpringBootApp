package urz.projekt.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import urz.projekt.model.Klient;
import urz.projekt.DAO.KlientDAO;

@Service("klientList")
public class KlientListImpl implements KlientList {

	@Autowired
	private KlientDAO klientDAO;

	@Override
	public List<Klient> getAllKlients() {
		return  klientDAO.findAll();
	}

	@Override
	public Klient getKlientById(long id) {
		return klientDAO.findOne(id);
	}

	public Klient getKlientByPesel(long pesel) {
		return klientDAO.findKlientByPesel(pesel);
	}
}