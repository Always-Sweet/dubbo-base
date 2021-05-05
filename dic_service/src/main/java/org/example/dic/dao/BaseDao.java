package org.example.dic.dao;

import java.util.List;

public interface BaseDao<T> {

    void save(T t);
    void update(T t);
    void delete(String id, String type);
    void batchDelete(String[] ids, String type);

    T get(String id);
    List<T> getOfPage(Integer page, Integer size);

}
