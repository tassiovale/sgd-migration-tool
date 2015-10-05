/*
 * 
 */
package sgd_import_xml.DAO;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import sgd_import_xml.entity.*;
import sgd_import_xml.utils.NumberUtils;
import sgd_import_xml.database.GenericDAO;

/**
 * The Class representing the data access for User objects.
 * 
 * @author tassiovale
 */
@Repository
public class UsuarioDAO extends GenericDAO<Usuario> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Saves an user in the database.
	 *
	 * @param user
	 *            the user to be saved
	 */
	@Transactional
	public void saveUser(Usuario usuario) {
		super.save(usuario);
	}

	/**
	 * Updates an user in the database.
	 *
	 * @param user
	 *            the user to be updated
	 */
	@Transactional
	public void updateUser(Usuario usuario) {
		super.update(usuario);
	}

	/**
	 * Removes an user in the database.
	 *
	 * @param user
	 *            the user to be removed
	 */
	@Transactional
	public void removeUser(Usuario usuario) {
		super.delete(usuario);
	}

	/**
	 * Find an specific user by SIAPE or email.
	 * 
	 * @param email
	 *            the intended email
	 * @return the resulting user
	 */
	public Usuario findBySiapeOrEmail(String siapeEmail) {
		Criteria criteria = getCriteria();

		Integer conversionResult = NumberUtils.convertStringToInteger(siapeEmail);
		if (conversionResult != null) {
			criteria.add(
					Restrictions.or(Restrictions.eq("siape", conversionResult), Restrictions.eq("email", siapeEmail)));
		} else {
			criteria.add(Restrictions.eq("email", siapeEmail));
		}

		return (Usuario) criteria.uniqueResult();
	}

	public Usuario findBySiape(int siape) {
		return (Usuario) getCriteria().add(Restrictions.eq("siape", siape)).uniqueResult();
	}
	
	public Usuario findByEmail(String email) {
		return (Usuario) getCriteria().add(Restrictions.eq("email", email)).uniqueResult();
	}

	public Usuario getSessionUser() {
		try{
			return this.findBySiape(Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName()));
		}catch(Exception ex){
			return null;
		}
	}

}
