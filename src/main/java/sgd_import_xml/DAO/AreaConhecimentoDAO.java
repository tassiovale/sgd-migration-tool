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
public class AreaConhecimentoDAO extends GenericDAO<AreaConhecimento> implements Serializable{

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
	public void saveArea(AreaConhecimento ac) {
		super.save(ac);
	}
	
	@Transactional
	public void saveArea(List<AreaConhecimento> ac) {
		super.save(ac);
	}

	/**
	 * Updates an AreaConhecimento in the database.
	 *
	 * @param AreaConhecimento the AreaConhecimento to be updated
	 */
	@Transactional
	public void update(AreaConhecimento ac) {
		super.update(ac);
	}
	
	@Transactional
	public void update(List<AreaConhecimento> ac) {
		super.update(ac);
	}

	/**
	 * Removes an user in the database.
	 *
	 * @param user the user to be removed
	 */
	@Transactional
	public void remove(AreaConhecimento ac) {
		getSession().refresh(ac);
		Hibernate.initialize(ac.getDocentes());
		
		List<Docente> docentes = ac.getDocentes();
		for(Docente d : docentes){
			d.setArea(null);
			docenteDAO.update(d);
		}
		super.delete(ac);
	}

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public AreaConhecimento findByAreaConhecimento(String area){
		return (AreaConhecimento) getCriteria().add(Restrictions.eq("nomeArea", area)).uniqueResult();
	}
	
	public AreaConhecimento findByID(int area){
		return (AreaConhecimento) getCriteria().add(Restrictions.eq("idArea", area)).uniqueResult();
	}
	
	@SuppressWarnings("rawtypes")
	public List findByParteAreaConhecimento(String parteArea){
		return getCriteria().add(Restrictions.ilike("nomeArea", "%" + parteArea + "%")).list();
	}

}
