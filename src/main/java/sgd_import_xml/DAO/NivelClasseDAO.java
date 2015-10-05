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
public class NivelClasseDAO extends GenericDAO<NivelClasse> implements Serializable{

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
	public void saveNivelClasse(NivelClasse ch) {
		super.save(ch);
	}

	/**
	 * Updates an AreaConhecimento in the database.
	 *
	 * @param AreaConhecimento the AreaConhecimento to be updated
	 */
	@Transactional
	public void update(NivelClasse ch) {
		super.update(ch);
	}

	/**
	 * Removes an user in the database.
	 *
	 * @param user the user to be removed
	 */
	@Transactional
	public void remove(NivelClasse ch) {
		getSession().refresh(ch);
		Hibernate.initialize(ch.getDocentes());
		
		List<Docente> docentes = ch.getDocentes();
		for(Docente d : docentes){
			d.setNivelClasse(null);
			docenteDAO.update(d);
		}
		super.delete(ch);
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public NivelClasse findByNivelClasse(String nivel){
		return (NivelClasse) getCriteria().add(Restrictions.eq("nivelClasse", nivel)).uniqueResult();
	}
	
	@SuppressWarnings("rawtypes")
	public List findByParteNivelClasse(String nivel){
		return getCriteria().add(Restrictions.ilike("nivelClasse", "%" + nivel + "%")).list();
	}
	
}
