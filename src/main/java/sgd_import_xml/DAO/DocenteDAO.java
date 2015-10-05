package sgd_import_xml.DAO;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sgd_import_xml.entity.*;
import sgd_import_xml.database.GenericDAO;


@Repository
public class DocenteDAO extends GenericDAO<Docente> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * Saves an user in the database.
	 *
	 * @param papelUsuario the user to be saved
	 */
	@Transactional
	public void saveDocente(Docente doc) {
		super.save(doc);
	}

	/**
	 * Updates an user in the database.
	 *
	 * @param user the user to be updated
	 */
	@Transactional
	public void update(Docente doc) {
		super.update(doc);
	}

	/**
	 * Removes an user in the database.
	 *
	 * @param user the user to be removed
	 */
	@Transactional
	public void remove(Docente doc) {
		super.delete(doc);
	}
	
	public Docente findBySiape(int siape){
		return (Docente) getCriteria().add(Restrictions.eq("siape", siape)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Docente> findByEmail(String email){
		Criteria criteria = getCriteria().add(Restrictions.ilike("email", "%" + email + "%"));
		criteria.addOrder(Order.asc("nome"));
		return (List<Docente>) criteria.list();
	}
	
	public Docente findUniqueEmail(String email){
		return (Docente) getCriteria().add(Restrictions.eq("email", email)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Docente> findByNome(String nome){
		Criteria criteria = getCriteria().add(Restrictions.ilike("nome", "%" + nome + "%"));
		criteria.addOrder(Order.asc("nome"));
		return (List<Docente>) criteria.list();
	}
	
//	public void updatePropriedades(String propriedade){
//		System.out.println("update Docente d set d."+propriedade+ " = none");
//		Query query = getSession().createQuery("update Docente d set d."+propriedade+ " = none");
//		query.executeUpdate();
//	}

}
