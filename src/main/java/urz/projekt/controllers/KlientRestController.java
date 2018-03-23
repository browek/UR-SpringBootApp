package urz.projekt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import urz.projekt.model.Klient;
import urz.projekt.DAO.KlientDAO;

@RestController
public class KlientRestController {
	@Autowired
	private KlientDAO klientList;
	
	@RequestMapping(path="/listaklientow", method=RequestMethod.GET)
	public List<Klient> getAllKlients(){
		return klientList.findAll();
	}
	
    @RequestMapping(value = "/klient/{id}", method = RequestMethod.GET)
	public Klient getKlientById(@PathVariable("id") long id){
		return klientList.getOne(id);
	}


    

}
