package id.co.ikm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.ikm.model.Loket;

@Service
public class LoketDAO {
	
	@Autowired
	private EntityManagerFactory factory;
	
	@SuppressWarnings("unchecked")
	public List<Loket> getAllLoket(){
		return (List<Loket>) factory.createEntityManager().createQuery("from Loket").getResultList();
	}
	
	public Loket getLoket(short id) {
		return (Loket) factory.createEntityManager().createQuery("from Loket where idloket = " + id).getSingleResult();
	}
	
	public boolean addLoket(Loket loket) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = em.getTransaction();
			transaksi.begin();
			em.persist(loket);
			transaksi.commit();
		} catch (Exception ex) {
			transaksi.rollback();
			isSuccess = false;
		}
		return isSuccess;
	}
	
	public boolean editLoket(Loket updateLoket) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = em.getTransaction();
			transaksi.begin();
			Loket existingLoket = (Loket) em.find(Loket.class, updateLoket.getIdloket());
			existingLoket.setNama(updateLoket.getNama());
			transaksi.commit();
		}catch (Exception ex) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(ex.getMessage());
		}
		return isSuccess;
	}
}
