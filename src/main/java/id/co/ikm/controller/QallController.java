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
import id.co.ikm.dao.QallDAO;
import id.co.ikm.dao.RespondenDAO;
import id.co.ikm.model.AnswerAll;
import id.co.ikm.model.Qall;
import id.co.ikm.model.Responden;
import id.co.ikm.service.QallService;

@Controller
@RequestMapping("qall")
public class QallController {

	private QallService qallService;
	
	@Autowired
	public QallController(QallService qallService) {
		this.qallService = qallService;
	}
	
	@Autowired
	private AnswerAllDAO answerallDAO;
	
	@Autowired
	private RespondenDAO respondenDAO;
	
	@Autowired
	private QallDAO qallDAO;
	
	@GetMapping("/indexanswer/{id}")
	public String index(Model model, @PathVariable("id") short id) {
		model.addAttribute("semuaQall", qallDAO.getAllQall());
		AnswerAll answerall = new AnswerAll();
		model.addAttribute("objekAnswer", answerall);
		model.addAttribute("objekResponden", respondenDAO.getResponden(id));
		return "qall/indexanswer";
	}
	
	@PostMapping("/indexanswer")
	public String saveAnswer(@Valid AnswerAll answerall, BindingResult result) {
		//System.out.println("test "+!result.hasErrors()+" "+answerallDAO.addAnswerAll(answerall));
		
		if(!result.hasErrors() && answerallDAO.addAnswerAll(answerall)) {
			Responden id = answerall.getNores();
			int a = id.getNores();
			return "redirect:/qall/indexanswer/"+a;
		} else {
			for (ObjectError er:result.getAllErrors()) {
				System.out.println(er.getDefaultMessage());
			}
			return "qall/indexanswer";
		}
	}
	
	@GetMapping("/detail/{idQall}")
	public String detail(Model model, @PathVariable("idQall") String id) {
		model.addAttribute("objekQuestion", qallDAO.getQuestion(id));
		AnswerAll answerall = new AnswerAll();
		model.addAttribute("getAnswerall", answerall);
		return "qall/detail";
	}
	
	@PostMapping("/detail")
	public String addAnswer(@Valid AnswerAll answerall, BindingResult result) {
		System.out.println("test "+result.hasErrors()+" "+answerallDAO.addAnswerAll(answerall));
		
		if(!result.hasErrors() && answerallDAO.addAnswerAll(answerall)) {
			return "redirect:/qall/indexanswer";
		} else {
			for (ObjectError er:result.getAllErrors()) {
				System.out.println(er.getDefaultMessage());
			}
			return "/qall/indexanswer";
		}
	}
	
	@GetMapping("/add")
	public String addForm(Model model) {
		Qall qall = new Qall();
		model.addAttribute("qall", qall);
		return "qall/add";
	}
	
	@PostMapping("/add")
	public String addQall(@Valid Qall qall, BindingResult result) {
		if(!result.hasErrors() && qallDAO.addQall(qall)) {
			return "redirect:/qall/indexanswer";
		} else {
			for (ObjectError er : result.getAllErrors()) {
				System.out.println(er.getDefaultMessage());
			}
			return "qall/add";
		}
	}
	
	
	@GetMapping("/edit/{idQall}")
	public String editForm(Model model, @PathVariable("idQall") String Id) {
		model.addAttribute("qall", qallDAO.getQall(Id));
		return "qall/edit";
	}
	
	@PostMapping("/edit")
	public String editQall(@Valid Qall qall, BindingResult result) {
		if(!result.hasErrors() && qallDAO.editQall(qall)) {
			return "redirect:/qall/indexanswer";
		} else {
			return "qall/edit/";
		}
	}
	
//	@RequestMapping(value ="/qall/delete/{idQall}")
//	public String delete(@PathVariable String idQall) {
//		qallDAO.delete(idQall);
//		return "redirect:/qall/index";
//	}
	
//	@GetMapping("/index/{idQall}")
//	public String deleteForm(Model model, @PathVariable ("idQall") String Id) {
//		model.addAttribute("qall", qallDAO.getQall(Id));
//		return "/qall/index";
//	}
	
//	@RequestMapping("/index/{idQall}")
//	public String deleteQall(@Valid Qall qall, BindingResult result) {
//		if(!result.hasErrors() && qallDAO.deleteQall(qall)) {
//			return "redirect:/qall/index";
//		} else {
//			return "qall/index";
//		}
//	}
	
	@RequestMapping(value="/index/{idQall}")
	public String deleteQall(@PathVariable String idQall) {
		qallService.deleteQall(idQall);
		return "redirect:/qall/indexanswer";
	}
	
}
