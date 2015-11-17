package sgd_import_xml.DAO;


import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import sgd_import_xml.entity.*;
import sgd_import_xml.database.GenericDAO;


@Repository
public class CargoDocenteDAO extends GenericDAO<HistoricoCargo> implements Serializable{

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
	public void saveCargoDocente(HistoricoCargo ch) {
		super.save(ch);
	}

	/**
	 * Updates an AreaConhecimento in the database.
	 *
	 * @param AreaConhecimento the AreaConhecimento to be updated
	 */
	@Transactional
	public void update(HistoricoCargo ch) {
		super.update(ch);
	}

	/**
	 * Removes an user in the database.
	 *
	 * @param user the user to be removed
	 */
	@Transactional
	public void remove(HistoricoCargo ch) {
		super.delete(ch);
	}

	
}
