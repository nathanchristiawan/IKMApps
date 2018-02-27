package id.co.ikm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.ikm.model.AnswerLoket;

@Service
public class AnswerLoketDAO {

	@Autowired
	private EntityManagerFactory factory;
	
	@SuppressWarnings("unchecked")
	public List<AnswerLoket> getAllAnswerLoket(){
		return (List<AnswerLoket>) factory.createEntityManager().createQuery("from AnswerLoket").getResultList();
	}
	
	public AnswerLoket getAnswerLoket(Integer id) {
		return (AnswerLoket) factory.createEntityManager().createQuery("from AnswerLoket where idAnswLoket = "+id).getSingleResult();
	}
	
	public boolean addAnswerLoket(AnswerLoket answerloket) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = em.getTransaction();
			transaksi.begin();
			em.persist(answerloket);
			transaksi.commit();
		} catch (Exception ex) {
			transaksi.rollback();
			isSuccess = false;
		}
		return isSuccess;
	}
	
	public boolean editAnswerLoket(AnswerLoket updateAnswerLoket) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = em.getTransaction();
			transaksi.begin();
			AnswerLoket existingAnswerLoket = (AnswerLoket) em.find(AnswerLoket.class, updateAnswerLoket.getIdAnswLoket());
			existingAnswerLoket.setNores(updateAnswerLoket.getNores());
			existingAnswerLoket.setIdloket(updateAnswerLoket.getIdloket());
			existingAnswerLoket.setIdQloket(updateAnswerLoket.getIdQloket());
			existingAnswerLoket.setAnswLoket(updateAnswerLoket.getAnswLoket());
			transaksi.commit();
		} catch (Exception ex) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(ex.getMessage());
		}
		return isSuccess;
	}
	
}
