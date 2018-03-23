package urz.projekt.DAO;

import java.util.List;

import urz.projekt.model.Samochod;

public interface SamochodList {
	public List<Samochod> getAllSamochods();
	public Samochod getSamochodById(long id);

}
