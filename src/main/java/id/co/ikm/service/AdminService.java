package id.co.ikm.service;

import java.util.List;

import id.co.ikm.model.Admin;

public interface AdminService {
	
	List <Admin> listAdmin();
	
	void deleteAdmin(String useradmin);
}
