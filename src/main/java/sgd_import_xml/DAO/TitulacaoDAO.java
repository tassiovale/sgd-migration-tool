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
public class TitulacaoDAO extends GenericDAO<Titulacao> implements Serializable{

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
	public void saveTitulacao(Titulacao ac) {
		super.save(ac);
	}
	
	@Transactional
	public void saveTitulacao(List<Titulacao> ac) {
		super.save(ac);
	}

	/**
	 * Updates an AreaConhecimento in the database.
	 *
	 * @param AreaConhecimento the AreaConhecimento to be updated
	 */
	@Transactional
	public void update(Titulacao ac) {
		super.update(ac);
	}

	/**
	 * Removes an user in the database.
	 *
	 * @param user the user to be removed
	 */
	@Transactional
	public void remove(Titulacao ac) {
		getSession().refresh(ac);
		Hibernate.initialize(ac.getDocentes());
		
		List<Docente> docentes = ac.getDocentes();
		for(Docente d : docentes){
			d.setTitulacao(null);
			docenteDAO.update(d);
		}
		super.delete(ac);
	}

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Titulacao findByTitulacao(String titulacao){
		return (Titulacao) getCriteria().add(Restrictions.eq("titulacao",titulacao)).uniqueResult();
	}
	
	public Titulacao findByID(int titulacao){
		return (Titulacao) getCriteria().add(Restrictions.eq("idTitulacao",titulacao)).uniqueResult();
	}
	
	@SuppressWarnings("rawtypes")
	public List findByParteTitulacao(String titulacao){
		return getCriteria().add(Restrictions.ilike("titulacao", "%" + titulacao + "%")).list();
	}

}
