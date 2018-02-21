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

import id.co.ikm.dao.AnswerAllDAO;
import id.co.ikm.model.AnswerAll;

@Controller
@RequestMapping("answerall")
public class AnswerAllController {

	@Autowired
	private AnswerAllDAO answerallDAO;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("semuaAnswerAll", answerallDAO.getAllAnswerAll());
		return "answerall/index";
	}
	
	@GetMapping("/add")
	public String addForm(Model model) {
		AnswerAll answerall = new AnswerAll();
		model.addAttribute("answerall", answerall);
		return "answerall/add";
	}
	
	@PostMapping("/add")
	public String addAnswerAll(@Valid AnswerAll answerall, BindingResult result) {
		if(!result.hasErrors() && answerallDAO.addAnswerAll(answerall)) {
			return "redirect:/answerall/index";
		} else {
			for (ObjectError er : result.getAllErrors()) {
				System.out.println(er.getDefaultMessage());
			}
			return "answerall/add";
		}
	}
	
	@GetMapping("/edit/{idAnswerAll}")
	public String editForm(Model model, @PathVariable("idAnswerAll") Integer id) {
		model.addAttribute("answerall", answerallDAO.getAnswerAll(id));
		return "answerall/edit";
	}
	
	@PostMapping("/edit")
	public String editAnswerAll(@Valid AnswerAll answerall, BindingResult result) {
		if(!result.hasErrors() && answerallDAO.editAnswerAll(answerall)) {
			return "redirect:/answerall/index";
		} else {
			return "answerall/edit/";
		}
	}
}
