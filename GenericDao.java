/*
 * 
 */
package br.ufba.dcc.rise.model.database;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
 
/**
 * The Class GenericDao is the superclass for the custom data access object classes.
 * This class is never used directly by controller classes, instead, subclasses extend GenericDao to provide specific behavior
 * according to the entity.
 * In this class, the entities are objects from classes mapped in the database.
 *
 * @param <T> the class type to be used in the custom data access object
 * 
 * @author tassiovale
 */
public class GenericDao<T extends Serializable> {
 
    private final Session session;
    
    private final Class<T> persistentClass;
 
    /**
     * Class constructor.
     */
    @SuppressWarnings("unchecked")
	public GenericDao() {
        this.session = HibernateUtil.getSession();
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
 
    /**
     * Gets the Hibernate session.
     *
     * @return the Hibernate session
     */
    public Session getSession() {
        return session;
    }
 
    /**
     * Save an entity in the database.
     *
     * @param entity the entity to be saved
     */
    protected void save(T entity) {
        try {
            getSession().getTransaction().begin();
            getSession().save(entity);
            getSession().getTransaction().commit();
        } catch (Throwable t) {
            getSession().getTransaction().rollback();
            t.printStackTrace();
        } finally {
            close();
        }
    }
 
    /**
     * Update an entity in the database.
     *
     * @param entity the entity to be updated
     */
    protected void update(T entity) {
        try {
            getSession().getTransaction().begin();
            getSession().update(entity);
            getSession().getTransaction().commit();
        } catch (Throwable t) {
            getSession().getTransaction().rollback();
            t.printStackTrace();
        } finally {
            close();
        }
    }
 
    /**
     * Delete an entity in the database.
     *
     * @param entity the entity to be deleted
     */
    protected void delete(T entity) {
        try {
            getSession().getTransaction().begin();
            getSession().delete(entity);
            getSession().getTransaction().commit();
        } catch (Throwable t) {
            getSession().getTransaction().rollback();
            t.printStackTrace();
        } finally {
            close();
        }
    }
    
    /**
     * Gets the number of objects registered in the database.
     * If necessary, a constraint is added to the Hibernate query in order to filter the results.
     *
     * @param className class name of the desired objects 
     * @param constraintString the constraint string to filter results (null is used when the constraint is not necessary)
     * @return the number of objects for the class analyzed
     */
    public long getNumberOfObjects(String className, String constraintString){
    	String queryString = "select count(classObject) from " + className + " classObject";
    	if(constraintString != null)
    		queryString += " " + constraintString;
    	Query query = getSession().createQuery(queryString);
		return (Long) query.uniqueResult();
    }
 
    /**
     * Find all entities in the database.
     *
     * @return the resulting list of entities
     * @throws Exception exception from Hibernate
     */
    @SuppressWarnings("unchecked")
	public List<T> findAll() throws Exception {
        return getSession().createCriteria(persistentClass).list();
    }
 
    /**
     * Find entities in the database according to the value in the 'name' column.
     *
     * @param name the name to be searched
     * @return entity with the specified name
     */
    @SuppressWarnings("unchecked")
	public T findByName(String name) {
        return (T) getSession().createCriteria(persistentClass)
                .add(Restrictions.eq("name", name).ignoreCase()).uniqueResult();
    }
    
    /**
     * Find entities in the database according to a specific value in the specified column.
     *
     * @param columnName the table column to be analyzed 
     * @param value the desired value for the specified column
     * @return entity with the specified value in the specified column
     */
    @SuppressWarnings("unchecked")
	public T findByColumn(String columnName, String value) {
        return (T) getSession().createCriteria(persistentClass)
                .add(Restrictions.eq(columnName, value).ignoreCase()).uniqueResult();
    }
 
    /**
     * Find entities in the database according to the specified id.
     *
     * @param id the id of the entity to be searched
     * @return entity with the specified id
     */
    @SuppressWarnings("unchecked")
	public T findById(long id) {
        return (T) getSession().createCriteria(persistentClass)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }

    private void close() {
        if (getSession() != null && getSession().isOpen()) {
            getSession().close();
        }
    } 
}
