package id.co.ikm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.co.ikm.dao.QloketDAO;
import id.co.ikm.model.Qloket;

@Controller
@RequestMapping("qloket")
public class QloketController {

	@Autowired
	private QloketDAO qloketDAO;
	
	@GetMapping("/qloketindex")
	public String qloketindex(Model model) {
		model.addAttribute("semuaQloket", qloketDAO.getAllQloket());
		return "qloket/qloketindex";
	}
	
	@GetMapping("/addqloket")
	public String addForm(Model model) {
		Qloket qloket = new Qloket();
		model.addAttribute("qloket", qloket);
		return "qloket/addqloket";
	}
	
	@PostMapping("/addqloket")
	public String addQloket(@Valid Qloket qloket, BindingResult result) {
		if(!result.hasErrors() && qloketDAO.addQloket(qloket)) {
			return "redirect:/qloket/qloketindex";
		} else {
			for (ObjectError er : result.getAllErrors()) {
				System.out.println(er.getDefaultMessage());
			}
			return "qloket/addqloket";
		}
	}
	
	
	@GetMapping("/editqloket/{idQloket}")
	public String editForm(Model model, @PathVariable("idQloket") String Id) {
		
		model.addAttribute("qloket", qloketDAO.getQloket(Id));
		return "qloket/editqloket";
	}
	
	@PostMapping("/editQloket")
	public String editQloket(@Valid Qloket qloket, BindingResult result) {
		
		if(!result.hasErrors() && qloketDAO.editQloket(qloket)) {
			return "redirect:/qloket/qloketindex";
		} else {
			return "qloket/editqloket/";
		}
	}
}
