package id.co.ikm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.co.ikm.dao.LoketDAO;

@Controller
@RequestMapping("loket")
public class LoketController {
	
	@Autowired
	private LoketDAO loketDAO;
	
	@GetMapping("/loketindex")
	public String loketindex(Model model) {
		model.addAttribute("semuaLoket", loketDAO.getAllLoket());
		return "loket/loketindex";
	}
}
