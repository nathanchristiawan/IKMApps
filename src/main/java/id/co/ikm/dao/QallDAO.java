package id.co.ikm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.ikm.model.Qall;
import id.co.ikm.service.QallService;

@Service
public class QallDAO implements QallService{

	@Autowired
	private EntityManagerFactory factory;
	
	@SuppressWarnings("unchecked")
	public List<Qall> getAllQall(){
		return (List<Qall>) factory.createEntityManager().createQuery("from Qall").getResultList();
	}
	
	public Qall getQall(String id) {
		return (Qall) factory.createEntityManager().createQuery("from Qall where idQall = '"+id+"'").getSingleResult();
	}
	
	
	public boolean addQall(Qall qall) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = em.getTransaction();
			transaksi.begin();
			em.persist(qall);
			transaksi.commit();
		} catch (Exception ex) {
			transaksi.rollback();
			isSuccess = false;
		}
		return isSuccess;
	}
	
	public boolean editQall(Qall updateQall) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = em.getTransaction();
			transaksi.begin();
			Qall existingQall = (Qall) em.find(Qall.class, updateQall.getIdQall());
			existingQall.setQuestion(updateQall.getQuestion());
			transaksi.commit();
		} catch (Exception ex) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(ex.getMessage());
		}
		return isSuccess;
	}
	
	
//	public void delete(String idQall) {
//		EntityManager em = factory.createEntityManager();
//		em.getTransaction().begin();
//		em.remove(em.find(Qall.class, idQall));
//		em.getTransaction().commit();
//	}
	
	//DELETE METHOD
//	public boolean deleteQall(Qall deleteQall) {
//		EntityManager em = factory.createEntityManager();
//		EntityTransaction transaksi = null;
//		boolean isSuccess = true;
//		try {
//			transaksi = em.getTransaction();
//			transaksi.begin();
//			Qall existingQall = (Qall) em.find(Qall.class, deleteQall.getIdQall());
//			existingQall.setQuestion(deleteQall.getQuestion());
//			transaksi.commit();
//		} catch (Exception ex) {
//			transaksi.rollback();
//			isSuccess = false;
//			System.out.println(ex.getMessage());
//		}
//		return isSuccess;
//		}

@Override
public List<Qall> listQall() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void deleteQall(String idQall) {
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();
	em.remove(em.find(Qall.class, idQall));
	em.getTransaction().commit();
}
	
	

}
