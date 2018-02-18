package id.co.ikm.service;

import java.util.List;

import id.co.ikm.model.Qall;

public interface QallService {
	
	
	List <Qall> listQall();
	
	void deleteQall(String idQall);
}
