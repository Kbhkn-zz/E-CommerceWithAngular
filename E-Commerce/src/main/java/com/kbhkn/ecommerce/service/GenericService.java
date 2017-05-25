package com.kbhkn.ecommerce.service;

import java.util.List;

/**
 * Created by kbhkn on 4/30/17.
 */
public interface GenericService {
    public void save(Object object);

    public <T> Object findById(Class<T> className, Integer id);

    public <T> Object findByName(Class<T> className, String name);

    public void update(Object object);

    public <T> void delete(Class<T> className, Integer id);

    public <T> List<T> findAll(Class<T> className);
}
