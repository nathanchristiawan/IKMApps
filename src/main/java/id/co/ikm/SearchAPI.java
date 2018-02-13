package id.co.ikm;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.ikm.model.Responden;

@RestController
public class SearchAPI {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/respondens")
	public List<Responden> getAllRespondens(){
		return (List<Responden>) entityManagerFactory.createEntityManager().createQuery("from Responden").getResultList();
	}
	
//	@Autowired
//	private Responden responden;
//	@GetMapping("/respondenb")
//	public Responden getRespondenBean() {
//		return responden;
//	}
}
