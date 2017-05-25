package com.kbhkn.ecommerce.service;

import com.kbhkn.ecommerce.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kbhkn on 4/30/17.
 */
@Service
@Transactional
public class GenericServiceImpl implements GenericService {

    @Autowired
    private GenericDao genericDao;

    @Override
    public void save(Object object) {
        genericDao.save(object);
    }

    @Override
    public <T> Object findById(Class<T> className, Integer id) {
        return genericDao.findById(className, id);
    }

    @Override
    public <T> Object findByName(Class<T> className, String name) {
        return genericDao.findByName(className, name);
    }

    @Override
    public void update(Object object) {
        genericDao.update(object);
    }

    @Override
    public <T> void delete(Class<T> className, Integer id) {
        genericDao.delete(className, id);
    }

    @Override
    public <T> List<T> findAll(Class<T> className) {
        return genericDao.findAll(className);
    }

    public void setGenericDao(GenericDao genericDao) {
        this.genericDao = genericDao;
    }
}
