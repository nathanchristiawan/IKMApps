package id.co.ikm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.ikm.model.AnswerAll;

@Service
public class AnswerAllDAO {

	@Autowired
	private EntityManagerFactory factory;
	
	@SuppressWarnings("unchecked")
	public List<AnswerAll> getAllAnswerAll(){
		return (List<AnswerAll>) factory.createEntityManager().createQuery("from AnswerAll").getResultList();
	}
	
	public AnswerAll getAnswerAll(Integer id) {
		return (AnswerAll) factory.createEntityManager().createQuery("from AnswerAll where idAnswAll = '"+id+"'").getSingleResult();
	}
	
	public boolean addAnswerAll(AnswerAll answerall) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = em.getTransaction();
			transaksi.begin();
			em.persist(answerall);
			transaksi.commit();
		} catch (Exception ex) {
			transaksi.rollback();
			isSuccess = false;
		}
		return isSuccess;
	}
	
	public boolean editAnswerAll(AnswerAll updateAnswerAll) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = em.getTransaction();
			transaksi.begin();
			AnswerAll existingAnswerAll = (AnswerAll) em.find(AnswerAll.class, updateAnswerAll.getIdAnswAll());
			existingAnswerAll.setNores(updateAnswerAll.getNores());
			existingAnswerAll.setIdQall(updateAnswerAll.getIdQall());
			existingAnswerAll.setAnswerAll(updateAnswerAll.getAnswerAll());
			transaksi.commit();
		} catch (Exception ex) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(ex.getMessage());
		}
		return isSuccess;
	}
}
