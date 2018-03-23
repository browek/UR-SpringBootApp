package urz.projekt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import urz.projekt.model.Samochod;
import urz.projekt.DAO.SamochodDAO;

@RestController
public class SamochodRestController {
	@Autowired
	private SamochodDAO samochodList;
	
	@RequestMapping(path="/listasamochodow", method=RequestMethod.GET)
	public List<Samochod> getAllSamochods(){
		return samochodList.findAll();
	}
	
    @RequestMapping(value = "/samochod/{id}", method = RequestMethod.GET)
	public Samochod getSamochodById(@PathVariable("id") long id){
		return samochodList.getOne(id);
	}

}
