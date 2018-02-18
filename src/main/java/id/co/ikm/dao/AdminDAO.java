package id.co.ikm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.ikm.model.Admin;

import id.co.ikm.service.AdminService;

@Service
public class AdminDAO implements AdminService {

	@Autowired
	private EntityManagerFactory factory;
	
	@SuppressWarnings("unchecked")
	public List<Admin> getAllAdmin(){
		return (List<Admin>) factory.createEntityManager().createQuery("from Admin").getResultList();
	}
	
	public Admin getAdmin(String id) {
		return (Admin) factory.createEntityManager().createQuery("from Admin where useradmin = '"+id+"'").getSingleResult();
	}
	
	public boolean addAdmin(Admin admin) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = em.getTransaction();
			transaksi.begin();
			em.persist(admin);
			transaksi.commit();
		} catch (Exception ex) {
			transaksi.rollback();
			isSuccess =false;
		}
		return isSuccess;
	}
	
	
	
	public boolean editAdmin(Admin updateAdmin) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			transaksi = em.getTransaction();
			transaksi.begin();
			Admin existingAdmin = (Admin) em.find(Admin.class, updateAdmin.getUseradmin());
			existingAdmin.setPw(updateAdmin.getPw());
			transaksi.commit();
		} catch (Exception ex) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(ex.getMessage());
		}
		return isSuccess;
	}

	@Override
	public List<Admin> listAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAdmin(String useradmin) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Admin.class, useradmin));
		em.getTransaction().commit();
		
	}
}
