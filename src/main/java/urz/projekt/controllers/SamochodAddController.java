package urz.projekt.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import urz.projekt.DAO.KlientDAO;
import urz.projekt.DAO.SamochodDAO;
import urz.projekt.model.Klient;
import urz.projekt.model.KlientSamochod;
import urz.projekt.model.Samochod;

@Controller
public class SamochodAddController {
	@Autowired
	private SamochodDAO samochodDAO;
	
	@Autowired
	private KlientDAO klientDAO;
	
	@RequestMapping(path="/samochodyLista", method=RequestMethod.GET)
	public String getAllSamochodsHtml(){
		return "listasamochodow";
	}
	
	@GetMapping("/samochody")
	public String dodajSamochod(Model model) {
		model.addAttribute("samochod", new Samochod());
		model.addAttribute("klientSamochodu", new Klient());
		return "samochody";
	}
	
	@PostMapping("/wyslijsamochod")
	public String wyslijsamochod(@ModelAttribute("samochod") Samochod samochod) {
		System.out.println(samochod.getMarka() + " " + samochod.getModel() +" "+ samochod.getRok_produkcji());
		
		samochodDAO.save(samochod);
		
		return "redirect:/samochody";
	}
	@GetMapping("/samochodyklient")
	public String samochodKlient(Model model) {
		model.addAttribute("klientsamochod", new KlientSamochod());
		List<Klient> Lista = klientDAO.findAll();
		List<Samochod> Lista2 = samochodDAO.findAll();
		model.addAttribute("Listaklientow", Lista);
		model.addAttribute("Listasamochodow", Lista2);
		
		return "samochodyklient";
	}

	@PostMapping("/wyslijsamochodklient")
	public String samochodKlient(@ModelAttribute("klientsamochod") KlientSamochod ks) {
		Klient k = klientDAO.findOne(ks.getIdklienta());
		Samochod s = samochodDAO.findOne(ks.getIdsamochodu());
		s.setKlient(k);
		
		samochodDAO.save(s);
		
		return "redirect:/samochodyklient";
	}
	@PostMapping("/addbutton")
	public String addbutton(@ModelAttribute("klientsamochod") KlientSamochod ks) {
		Klient k = klientDAO.findOne(ks.getIdklienta());
		Samochod s = samochodDAO.findOne(ks.getIdsamochodu());
		k.getSamochody().add(s);
		s.setKlient(k);
		samochodDAO.save(s);
		
		return "redirect:/samochodyklient";
	}
	
	@GetMapping("/clear/samochod/{id}")
	public String clearSamochod(@PathVariable("id")Long id, Model model) {	
		Samochod samochod = samochodDAO.findOne(id);
		samochod.setKlient(null);
		samochodDAO.save(samochod);
	return "redirect:/samochodyklient";	
	}
	
}
