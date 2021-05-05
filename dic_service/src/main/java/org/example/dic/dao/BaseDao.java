package org.example.dic.dao;

import java.util.List;

public interface BaseDao<T> {

    void save(T Object);
    void update(T Object);
    void delete(T Object, String type);
    void batchDelete(List<T> Objects, String type);

    T get(String id);
    List<T> getOfPage(Integer page, Integer size);

}
