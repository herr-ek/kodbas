package se.oakstone.logwatch.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
 

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return configureSessionFactory();

    }
    
    public static Session beginTransaction() {
    	Session hibernateSession = HibernateUtil.getSession();
    	hibernateSession.beginTransaction();
    	return hibernateSession;
    }
    	 
    public static void commitTransaction() {
    	HibernateUtil.getSession().getTransaction().commit();
    }
    	 
    public static void rollbackTransaction() {
    	HibernateUtil.getSession().getTransaction().rollback();
    }
    	 
    public static void closeSession() {
    	HibernateUtil.getSession().close();
    }
    	 
    public static Session getSession() {
    	Session hibernateSession = sessionFactory.getCurrentSession();
    	return hibernateSession;
    }

}