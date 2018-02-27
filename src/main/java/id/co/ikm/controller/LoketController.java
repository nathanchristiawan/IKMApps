package id.co.ikm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.co.ikm.dao.LoketDAO;
import id.co.ikm.model.Loket;

@Controller
@RequestMapping("loket")
public class LoketController {
	
	@Autowired
	private LoketDAO loketDAO;
	
	@GetMapping("/loketindex")
	public String loketindex(Model model) {
		Loket loket = new Loket();
		model.addAttribute("loket", loket);
		model.addAttribute("semuaLoket", loketDAO.getAllLoket());
		return "loket/loketindex";
	}
	
	/*@PostMapping("/loketindex")
	public String loketindexpost(@Valid Loket loket, BindingResult result) {
		if(!result.hasErrors() && loketDAO.addLoket(loket)) {
			String id = loket.getIdloket();
			return "redirect:/qloket/qloketindex/'"+id+"'";
		} else {
			for (ObjectError er : result.getAllErrors()) {
				System.out.println(er.getDefaultMessage());
		}
		}
			return "loket/loketindex";
	}*/
}
