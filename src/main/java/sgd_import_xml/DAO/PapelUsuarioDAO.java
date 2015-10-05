package sgd_import_xml.DAO;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sgd_import_xml.entity.*;
import sgd_import_xml.database.GenericDAO;

@Repository
public class PapelUsuarioDAO extends GenericDAO<PapelUsuario> implements Serializable{

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
	public void savePapelUser(PapelUsuario papelUsuario) {
		super.save(papelUsuario);
	}

	/**
	 * Updates an user in the database.
	 *
	 * @param user the user to be updated
	 */
	@Transactional
	public void updatePapelUser(PapelUsuario papelUsuario) {
		super.update(papelUsuario);
	}

	/**
	 * Removes an user in the database.
	 *
	 * @param user the user to be removed
	 */
	@Transactional
	public void removePapelUser(PapelUsuario papelUsuario) {
		super.delete(papelUsuario);
	}

	@Transactional
	public void removePapelUserByUser(Usuario usuario){
		getSession().refresh(usuario);
		Hibernate.initialize(usuario.getPapelUsuario());
		
		List<PapelUsuario> sPapelUsuario = usuario.getPapelUsuario();		
		for(PapelUsuario papel : sPapelUsuario){
			System.out.println("*******************" + papel.getId());
			super.delete(papel);
		}
	}

}
