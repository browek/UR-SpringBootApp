package urz.projekt.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import urz.projekt.model.Samochod;
import urz.projekt.DAO.SamochodDAO;

@Service("samochodList")
public class SamochodListImpl implements SamochodList {

	@Autowired
	private SamochodDAO samochodDAO;

	@Override
	public List<Samochod> getAllSamochods() {
		return  samochodDAO.findAll();
	}

	@Override
	public Samochod getSamochodById(long id) {
		return samochodDAO.findOne(id);
	}

}