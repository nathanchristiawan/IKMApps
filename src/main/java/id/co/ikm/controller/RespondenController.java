package id.co.ikm.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.co.ikm.dao.RespondenDAO;
import id.co.ikm.model.Responden;

@Controller
@RequestMapping("responden")
public class RespondenController {
	
	@Autowired
	private RespondenDAO respondenDAO;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("tanggal", new Date());
		model.addAttribute("semuaResponden", respondenDAO.getAllResponden());
		return "responden/index";
	}
	
	@GetMapping("/add")
	public String addForm(Model model) {
		Responden responden = new Responden();
		model.addAttribute("responden", responden);
		return "responden/add";
	}
	
	@PostMapping("/add")
	public String addResponden(@Valid Responden responden, BindingResult result) {
		if(!result.hasErrors() && respondenDAO.addResponden(responden)) {
			return "redirect:/responden/index";
		} else {
			for (ObjectError er : result.getAllErrors()) {
				System.out.println(er.getDefaultMessage());
			}
			return "responden/add";
		}
	}
}
