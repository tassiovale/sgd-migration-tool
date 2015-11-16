package sgd_import_xml.DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import sgd_import_xml.entity.*;
import sgd_import_xml.database.GenericDAO;

@Repository
public class CargoDAO extends GenericDAO<Cargo> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SessionFactory sessionFactory;

	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Saves an user in the database.
	 *
	 * @param user the user to be saved
	 */
	@Transactional
	public void saveCargo(Cargo c) {
		super.save(c);
	}
	
	@Transactional
	public void saveCargo(List<Cargo> c) {
		super.save(c);
	} 

	/**
	 * Updates an user in the database.
	 *
	 * @param user the user to be updated
	 */
	@Transactional
	public void update(Cargo c) {
		super.update(c);
	}

	/**
	 * Removes an user in the database.
	 *
	 * @param user the user to be removed
	 */
	@Transactional
	public void remove(Cargo c) {
		super.delete(c);
	}
	
	public Cargo findByCargo(String cargo){
		return (Cargo) getCriteria().add(Restrictions.eq("nomeCargo", cargo)).uniqueResult();
	}
	
	@SuppressWarnings("rawtypes")
	public List findByParteCargo(String cargo){
		return getCriteria().add(Restrictions.ilike("nomeCargo", "%" + cargo + "%")).list();
	}
	
}
