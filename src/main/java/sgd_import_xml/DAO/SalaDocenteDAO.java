package sgd_import_xml.DAO;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sgd_import_xml.entity.*;
import sgd_import_xml.database.GenericDAO;

@Repository
public class SalaDocenteDAO extends GenericDAO<SalaDocente> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private DocenteDAO docenteDAO;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Saves an user in the database.
	 *
	 * @param user the user to be saved
	 */
	@Transactional
	public void saveSalaDocente(SalaDocente c) {
		super.save(c);
	} 

	/**
	 * Updates an user in the database.
	 *
	 * @param user the user to be updated
	 */
	@Transactional
	public void updateSalaDocente(SalaDocente c) {
		super.update(c);
	}

	/**
	 * Removes an user in the database.
	 *
	 * @param user the user to be removed
	 */
	@Transactional
	public void removeSalaDocente(SalaDocente c) {
		getSession().refresh(c);
		Hibernate.initialize(c.getDocentes());

		List<Docente> docentes = c.getDocentes();
		for(Docente d : docentes){
			d.setSalaDocente(null);
			docenteDAO.update(d);
		}
		super.delete(c);
	}

	public SalaDocente findBySala(String sala){
		return (SalaDocente) getCriteria().add(Restrictions.eq("sala", sala)).uniqueResult();
	}

	public SalaDocente findByLocal(String local){
		return (SalaDocente) getCriteria().add(Restrictions.eq("local", local)).uniqueResult();
	}

	@SuppressWarnings("rawtypes")
	public List findByParteSalaOuLocal(String sala){
		return getCriteria().add(
				Restrictions.or(
						Restrictions.ilike("sala", "%" + sala + "%"), 
						Restrictions.ilike("local", "%" + sala + "%")
						)
				).list();
	}

}
