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

import id.co.ikm.dao.AnswerLoketDAO;
import id.co.ikm.model.AnswerLoket;

@Controller
@RequestMapping("answerloket")
public class AnswerLoketController {

	@Autowired
	private AnswerLoketDAO answerloketDAO;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("semuaAnswerLoket", answerloketDAO.getAllAnswerLoket());
		return "answerloket/index";
	}
	
	@GetMapping("/add")
	public String addForm(Model model) {
		AnswerLoket answerloket = new AnswerLoket();
		model.addAttribute("answerloket", answerloket);
		return "answerloket/add";
	}
	
	@PostMapping("/add")
	public String addAnswerLoket(@Valid AnswerLoket answerloket, BindingResult result) {
		if(!result.hasErrors() && answerloketDAO.addAnswerLoket(answerloket)) {
			return "redirect:/answerloket/index";
		} else {
			for (ObjectError er : result.getAllErrors()) {
				System.out.println(er.getDefaultMessage());
			}
			return "answerloket/add";
		}
	}
	
	@GetMapping("/edit/{idAnswLoket}")
	public String editForm(Model model, @PathVariable("idAnswLoket") Integer id) {
		model.addAttribute("answerloket", answerloketDAO.getAnswerLoket(id));
		return "answerloket/edit";
	}
	
	@PostMapping("/edit")
	public String editAnswerLoket(@Valid AnswerLoket answerloket, BindingResult result) {
		if(!result.hasErrors() && answerloketDAO.editAnswerLoket(answerloket)) {
			return "redirect:/answerloket/index";
		} else {
			return "answerloket/edit/";
		}
	}
}
