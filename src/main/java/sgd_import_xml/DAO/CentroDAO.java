package sgd_import_xml.DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import sgd_import_xml.database.GenericDAO;
import sgd_import_xml.entity.Centro;
import sgd_import_xml.entity.Docente;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CentroDAO extends GenericDAO<Centro> implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private SessionFactory sessionFactory;
	

	@Autowired
	private DocenteDAO docenteDAO;

		
	
	/**
	 * Saves an user in the database.
	 *
	 * @param user the user to be saved
	 */
	@Transactional
	public void saveCentro(Centro c) {
		super.save(c);
	}
	
	@Transactional
	public void saveCentro(List<Centro> c) {
		super.save(c);
	}

	/**
	 * Updates an AreaConhecimento in the database.
	 *
	 * @param AreaConhecimento the AreaConhecimento to be updated
	 */
	@Transactional
	public void update(Centro c) {
		super.update(c);
	}

	/**
	 * Removes an user in the database.
	 *
	 * @param user the user to be removed
	 */
	@Transactional
	public void remove(Centro c) {
		getSession().refresh(c);
		Hibernate.initialize(c.getDocentes());
		
		List<Docente> docentes = c.getDocentes();
		for(Docente d : docentes){
			d.setArea(null);
			docenteDAO.update(d);
		}
		super.delete(c);
	}

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	

	@SuppressWarnings("rawtypes")
	public List findByParteNomeCentro(String parteNomeCentro){
		return getCriteria().add(Restrictions.ilike("nomeCentro", "%" + parteNomeCentro + "%")).list();
	}

	public Centro findCentro(String centro){
		return (Centro) getCriteria().add(Restrictions.eq("nomeCentro", centro)).uniqueResult();
	}

}
