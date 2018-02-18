package id.co.ikm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.ikm.model.Qloket;


@Service
public class QloketDAO {

	@Autowired
	private EntityManagerFactory factory;
	
	@SuppressWarnings("unchecked")
	public List<Qloket> getAllQloket(){
		return (List<Qloket>) factory.createEntityManager().createQuery("from Qloket").getResultList();
	}
	
	public Qloket getQloket(String id) {
		return (Qloket) factory.createEntityManager().createQuery("from Qloket where idQloket = " + id).getSingleResult();
	}
	
	public boolean addQloket(Qloket qloket) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = em.getTransaction();
			transaksi.begin();
			em.persist(qloket);
			transaksi.commit();
		}catch (Exception ex) {
			transaksi.rollback();
			isSuccess = false;
		}
		return isSuccess;
	}
	
	
	public boolean editQloket(Qloket updateQloket) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = em.getTransaction();
			transaksi.begin();
			Qloket existingQloket = (Qloket) em.find(Qloket.class, updateQloket.getIdQloket());
			existingQloket.setQuestionLoket(updateQloket.getQuestionLoket());
			transaksi.commit();
		}catch (Exception ex) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(ex.getMessage());
		}
		return isSuccess;
	}
}
