/*
 * 
 */
package sgd_import_xml.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * The Class HibernateUtil instantiates the Hibernate session to be used in data access object classes.
 * 
 * @author tassiovale
 */
public class HibernateUtil {
	
	private static SessionFactory SESSION_FACTORY;
	 
    static{
//        try {
//        	// Create the SessionFactory from hibernate.cfg.xml
//        	Configuration config = new Configuration();
//        	config.configure();
//        	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
//            SESSION_FACTORY = config.configure().buildSessionFactory(serviceRegistry);
//        } catch (Throwable ex) {
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
    	
    	
    	try {
        	// Create the SessionFactory from hibernate.cfg.xml
        	Configuration config = new Configuration();
        	config.configure();
        	StandardServiceRegistryBuilder registerbuilder = new StandardServiceRegistryBuilder();
        	registerbuilder.applySettings(config.getProperties());
        	ServiceRegistry serviceRegistry = registerbuilder.build();
            SESSION_FACTORY = config.configure().buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    /**
     * Gets the Hibernate session.
     *
     * @return the Hibernate session
     */
    public static Session getSession(){
        return SESSION_FACTORY.openSession();
    }

}
