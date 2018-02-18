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

import id.co.ikm.dao.AdminDAO;
import id.co.ikm.model.Admin;
import id.co.ikm.service.AdminService;

@Controller
@RequestMapping("admin")
public class AdminController {

	private AdminService adminService;
	
	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@Autowired
	private AdminDAO adminDAO;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("semuaAdmin", adminDAO.getAllAdmin());
		return "admin/index";
	}
	
	@GetMapping("/homey")
	public String home() {
		return "admin/homey";
	}
	
	@GetMapping("/add")
	public String addForm(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "admin/add";
	}
	
	@PostMapping("/add")
	public String addAdmin(@Valid Admin admin, BindingResult result) {
		if(!result.hasErrors() && adminDAO.addAdmin(admin)) {
			return "redirect:/admin/index";
		} else {
			for (ObjectError er : result.getAllErrors()) {
				System.out.println(er.getDefaultMessage());
			}
			return "admin/add";
		}
	}
	
	@GetMapping("/edit/{useradmin}")
	public String editForm(Model model, @PathVariable ("useradmin") String Id) {
		model.addAttribute("admin", adminDAO.getAdmin(Id));
		return "admin/edit";
	}
	
	@PostMapping("/edit")
	public String editAdmin(@Valid Admin admin, BindingResult result) {
		if(!result.hasErrors() && adminDAO.editAdmin(admin)) {
			return "redirect:/admin/index";
		} else {
			return "admin/edit/";
		}
	}
	
	@RequestMapping(value="/index/{useradmin}")
	public String deleteAdmin(@PathVariable String useradmin) {
		adminService.deleteAdmin(useradmin);;
		return "redirect:/admin/index";
	}
	
}
