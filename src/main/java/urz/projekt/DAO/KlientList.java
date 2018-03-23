package urz.projekt.DAO;

import java.util.List;

import urz.projekt.model.Klient;

public interface KlientList {
	public List<Klient> getAllKlients();
	public Klient getKlientById(long id);



}
