package com.kbhkn.ecommerce.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kbhkn on 4/30/17.
 */
@Repository
public class GenericDaoImpl implements GenericDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Object object) {
        this.getSession().save(object);
    }

    @Override
    public <T> Object findById(Class<T> className, Integer id) {
        return this.getSession().get(className, id);
    }

    @Override
    public <T> Object findByName(Class<T> className, String name) {
        return this.getSession().get(className, name);
    }

    @Override
    public void update(Object object) {
        this.getSession().update(object);
    }

    @Override
    public <T> void delete(Class<T> className, Integer id) {
        if(id != null && id > 0){
            Object o = findById(className, id);
            this.getSession().delete(o);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> findAll(Class<T> className) {
        return this.getSession().createCriteria(className).list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
