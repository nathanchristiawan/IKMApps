package id.co.ikm.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
//import javax.persistence.PersistenceContext;
//import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import id.co.ikm.model.Responden;

@Service
public class RespondenDAO {
	
//	@PersistenceContext
	@Autowired
	private EntityManagerFactory factory;
	
//	@Bean
//	@Qualifier(value = "entityManager")
//	public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
//		return entityManagerFactory.createEntityManager();
//	}
	
	@SuppressWarnings("unchecked")
	public List<Responden> getAllResponden(){
		return (List<Responden>) factory.createEntityManager().createQuery("from Responden").getResultList();
	}
	
	public Responden getResponden(short id) {
		return (Responden) factory.createEntityManager().createQuery("from Responden where nores = " + id).getSingleResult();
	}
	
	public boolean addResponden(Responden responden) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = em.getTransaction();
			transaksi.begin();
			responden.setTanggal(new Date());
			em.persist(responden);
			transaksi.commit();
		} catch (Exception ex) {
			transaksi.rollback();
			isSuccess = false;
		}
		return isSuccess;
	}
	
	
	public boolean editResponden(Responden updateResponden) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = em.getTransaction();
			transaksi.begin();
			Responden existingResponden = (Responden) em.find(Responden.class, updateResponden.getNores());
			existingResponden.setTanggal(new Date());
			existingResponden.setUmur(updateResponden.getUmur());
			existingResponden.setJk(updateResponden.getJk());
			existingResponden.setPendidikan(updateResponden.getPendidikan());
			existingResponden.setPekerjaan(updateResponden.getPekerjaan());
			existingResponden.setPeriode(updateResponden.getPeriode());
			transaksi.commit();
		} catch (Exception ex) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(ex.getMessage());
		}
		return isSuccess;
	}

}
