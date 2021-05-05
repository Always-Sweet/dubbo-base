package org.example.dic.dao;

import org.example.model.Dic;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DicDao implements BaseDao<Dic> {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(Dic dic) {

    }

    @Override
    public void update(Dic dic) {

    }

    @Override
    public void delete(String id, String type) {

    }

    @Override
    public void batchDelete(String[] ids, String type) {

    }

    @Override
    public Dic get(String id) {
        return entityManager.find(Dic.class, id);
    }

    @Override
    public List<Dic> getOfPage(Integer page, Integer size) {
        return null;
    }
}
