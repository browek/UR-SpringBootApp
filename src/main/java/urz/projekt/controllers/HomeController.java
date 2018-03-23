package urz.projekt.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import urz.projekt.DAO.SamochodDAO;
import urz.projekt.DAO.KlientDAO;
import urz.projekt.model.Klient;
import urz.projekt.model.Samochod;

@Controller
public class HomeController {
	
	@Autowired
	private KlientDAO klientDao;
	
	@Autowired
	private SamochodDAO samochodDao;
	
	@GetMapping("/")
	public String home(Model model) {
	List<Klient> Lista = klientDao.findAll();
	List<Samochod> Lista2 = samochodDao.findAll();
	model.addAttribute("Listaklientow", Lista);
	model.addAttribute("Listasamochodow", Lista2);
		return "index";
	}
	
	@GetMapping("/delete/klient/{id}")
	public String delKlient(@PathVariable("id")Long id, Model model) {	
		Klient klient = klientDao.findOne(id);
		for(Samochod s : klient.getSamochody())
		{
		s.setKlient(null);
		}
		klient.getSamochody().clear();
		klientDao.delete(id);
	return "redirect:/usunklienta";	
	}
	
	@GetMapping("/delete/samochod/{id}")
	public String delSamochod(@PathVariable("id")Long id, Model model) {	
		Samochod samochod = samochodDao.findOne(id);
		samochod.setKlient(null);
		samochodDao.delete(id);
	return "redirect:/usunsamochod";	
	}
	
	@GetMapping("/klienci")
	public String dodajKlienta(Model model) {
		model.addAttribute("klient", new Klient());
		return "klienci";
	}
	
		
	@PostMapping("/wyslijklient")
	public String wyslijklienta(@ModelAttribute("klient") Klient klient) {
		System.out.println(klient.getImie() + " " + klient.getNazwisko() +" "+ klient.getPesel());
		klientDao.save(klient);
		return "redirect:/klienci";
	}
	
	@RequestMapping(path="/klienciLista", method=RequestMethod.GET)
	public String getAllKlientsHtml(){
		return "listaklientow";
	}
	
	@GetMapping("/usunklienta")
	public String usunKlienta(Model model) {
		model.addAttribute("klient", new Klient());
		List<Klient> Lista = klientDao.findAll();
		model.addAttribute("Listaklientow", Lista);
		return "usunklienta";
	}
	@PostMapping("/usunklient")
	public String usunklient(@ModelAttribute("klient") Klient klient) {
		System.out.println(klient.getId());
		Klient k = klientDao.findOne(klient.getId());
		
		for(Samochod s : k.getSamochody()) {
			s.setKlient(null);
		}
		k.setSamochody(new ArrayList<Samochod>());
		klientDao.delete(k);
		return "redirect:/usunklienta";
	}
	@PostMapping("/usunklientp")
	public String usunklientp(@ModelAttribute("klient") Klient klient) {
		System.out.println(klient.getPesel());
		Klient k = klientDao.findKlientByPesel(klient.getPesel());
		for(Samochod s : k.getSamochody()) {
			s.setKlient(null);
		}
		k.setSamochody(new ArrayList<Samochod>());
		klientDao.delete(k);
		return "redirect:/usunklienta";
	}

	@GetMapping("/usunsamochod")
	public String usunSamochod(Model model) {
		model.addAttribute("samochod", new Samochod());		
		List<Samochod> Lista2 = samochodDao.findAll();
		model.addAttribute("Listasamochodow", Lista2);
		return "usunsamochod";
	}
	
	@PostMapping("/usunsamochody")
	public String usunsamochod(@ModelAttribute("samochod") Samochod samochod) {
		System.out.println(samochod.getId());
		Samochod s = samochodDao.findOne(samochod.getId());
		samochodDao.delete(s);
		return "redirect:/usunsamochod";
	}

}
