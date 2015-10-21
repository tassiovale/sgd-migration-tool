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
public class ClasseDocenteDAO extends GenericDAO<ClasseDocente> implements Serializable{

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
	public void saveClasseDocente(ClasseDocente ch) {
		super.save(ch);
	}
	
	@Transactional
	public void saveClasseDocente(List<ClasseDocente> ch) {
		super.save(ch);
	}

	/**
	 * Updates an AreaConhecimento in the database.
	 *
	 * @param AreaConhecimento the AreaConhecimento to be updated
	 */
	@Transactional
	public void update(ClasseDocente ch) {
		super.update(ch);
	}

	/**
	 * Removes an user in the database.
	 *
	 * @param user the user to be removed
	 */
	@Transactional
	public void remove(ClasseDocente ch) {
		getSession().refresh(ch);
		Hibernate.initialize(ch.getDocentes());
		
		List<Docente> docentes = ch.getDocentes();
		for(Docente d : docentes){
			d.setClasseDocente(null);
			docenteDAO.update(d);
		}
		super.delete(ch);
	}
	
	public ClasseDocente findByClasseDocente(String classe){
		return (ClasseDocente) getCriteria().add(Restrictions.eq("classeDocente", classe)).uniqueResult();
	}
	
	public ClasseDocente findByID(int classe){
		return (ClasseDocente) getCriteria().add(Restrictions.eq("idClasseDocente", classe)).uniqueResult();
	}
	
	@SuppressWarnings("rawtypes")
	public List findByParteClasseDocente(String classe){
		return getCriteria().add(Restrictions.ilike("classeDocente", "%" + classe + "%")).list();
	}
}

