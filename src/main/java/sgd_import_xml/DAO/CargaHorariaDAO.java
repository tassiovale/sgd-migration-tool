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
public class CargaHorariaDAO extends GenericDAO<CargaHoraria> implements Serializable{

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
	public void saveCargaHoraria(CargaHoraria ch) {
		super.save(ch);
	}
	
	@Transactional
	public void saveCargaHoraria(List<CargaHoraria> ch) {
		super.save(ch);
	}

	/**
	 * Updates an AreaConhecimento in the database.
	 *
	 * @param AreaConhecimento the AreaConhecimento to be updated
	 */
	@Transactional
	public void update(CargaHoraria ch) {
		super.update(ch);
	}

	/**
	 * Removes an user in the database.
	 *
	 * @param user the user to be removed
	 */
	@Transactional
	public void remove(CargaHoraria ch) {
		//getting the list of objects from lazy initialization
		getSession().refresh(ch);
		Hibernate.initialize(ch.getDocentes());
		
		List<Docente> docentes = ch.getDocentes();
		for(Docente d : docentes){
			d.setCargaHoraria(null);
			docenteDAO.update(d);
		}
		super.delete(ch);
	}

	public CargaHoraria findByCargaHoraria(float ch){
		return (CargaHoraria) getCriteria().add(Restrictions.eq("cargaHoraria", ch)).uniqueResult();
	}
	
	public CargaHoraria findByID(int ch){
		return (CargaHoraria) getCriteria().add(Restrictions.eq("idCargaHoraria", ch)).uniqueResult();
	}

}
