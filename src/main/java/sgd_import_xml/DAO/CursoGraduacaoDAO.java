package sgd_import_xml.DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sgd_import_xml.database.GenericDAO;
import sgd_import_xml.entity.CursoGraduacao;



@Repository
public class CursoGraduacaoDAO extends GenericDAO<CursoGraduacao> implements Serializable{
	

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
	public void saveCursoGraduacao(CursoGraduacao cg) {
		super.save(cg);
	}

	@Transactional
	public void saveCursoGraduacao(List<CursoGraduacao> cg) {
		super.save(cg);
	}

	/**
	 * Updates an user in the database.
	 *
	 * @param user
	 *            the user to be updated
	 */
	@Transactional
	public void updateCursoGraduacao(CursoGraduacao cg) {
		super.update(cg);
	}

	/**
	 * Removes an user in the database.
	 *
	 * @param user
	 *            the user to be removed
	 */
	@Transactional
	public void removeCursoGraduacao(CursoGraduacao cg) {
		super.delete(cg);
	}

	public CursoGraduacao findByCursoGraduacao(String curso) {
		return (CursoGraduacao) getCriteria().add(
				Restrictions.eq("curso", curso)).uniqueResult();
	}
	
	public CursoGraduacao findByID(int id) {
		return (CursoGraduacao) getCriteria().add(
				Restrictions.eq("idCursoGrad", id)).uniqueResult();
	}

	@SuppressWarnings("rawtypes")
	public List findByParteCursoGraduacao(String curso) {
		return getCriteria()
				.add(Restrictions.ilike("curso", "%" + curso + "%")).list();
	}

}
