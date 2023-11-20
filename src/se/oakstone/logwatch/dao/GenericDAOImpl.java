package se.oakstone.logwatch.dao;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
 
/**
 *
 * @author Nils
 */
public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {
 
    protected Session getSession() {
        return HibernateUtil.getSession();
    }
 
    public void save(T entity) {
        Session hibernateSession = this.getSession();
        hibernateSession.saveOrUpdate(entity);
    }
 
    public void merge(T entity) {
        Session hibernateSession = this.getSession();
        hibernateSession.merge(entity);
    }
 
    public void delete(T entity) {
        Session hibernateSession = this.getSession();
        hibernateSession.delete(entity);
    }
 
    public List<T> findMany(Query query) {
        List<T> t;
        t = (List<T>) query.list();
        return t;
    }
 
    public T findOne(Query query) {
        T t;
        t = (T) query.uniqueResult();
        return t;
    }
 
    public T findByID(Class<T> clazz, ID id) {
        Session hibernateSession = this.getSession();
        T t = null;
        t = (T) hibernateSession.get(clazz, id);
        return t;
    }
 
    public List<T> findAll(Class<T> clazz) {
        Session hibernateSession = this.getSession();
        List<T> list = null;
        Query query = hibernateSession.createQuery("from " + clazz.getName());
        list = query.list();
        return list;
    }
    
    public List<T> findAll(Class<T> clazz, String orderBy) {
        Session hibernateSession = this.getSession();
        List<T> list = null;
        Query query = hibernateSession.createQuery("from " + clazz.getName() + " Order by " + orderBy);
        list = query.list();
        return list;
    }

}