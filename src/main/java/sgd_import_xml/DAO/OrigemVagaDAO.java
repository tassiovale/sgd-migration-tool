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
public class OrigemVagaDAO extends GenericDAO<OrigemVaga> implements Serializable{

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
	 * @param papelUsuario the user to be saved
	 */
	@Transactional
	public void saveOrigemVaga(OrigemVaga doc) {
		super.save(doc);
	}
	
	@Transactional
	public void saveOrigemVaga(List<OrigemVaga> doc) {
		super.save(doc);
	}

	/**
	 * Updates an user in the database.
	 *
	 * @param user the user to be updated
	 */
	@Transactional
	public void update(OrigemVaga doc) {
		super.update(doc);
	}

	/**
	 * Removes an user in the database.
	 *
	 * @param user the user to be removed
	 */
	@Transactional
	public void remove(OrigemVaga doc) {
		getSession().refresh(doc);
		Hibernate.initialize(doc.getDocentes());
		
		List<Docente> docentes = doc.getDocentes();
		for(Docente d : docentes){
			d.setOrigemVaga(null);
			docenteDAO.update(d);
		}
		super.delete(doc);
	}
	
	public OrigemVaga findByOrigemVaga(String ov){
		return (OrigemVaga) getCriteria().add(Restrictions.ilike("origemVaga", ov)).uniqueResult();
	}
	
	public OrigemVaga findByID(int ov){
		return (OrigemVaga) getCriteria().add(Restrictions.eq("idOrigemVaga", ov)).uniqueResult();
	}
	
	@SuppressWarnings("rawtypes")
	public List findByParteOrigemVaga(String ov){
		return getCriteria().add(Restrictions.ilike("origemVaga", "%" + ov + "%")).list();
	}

}
