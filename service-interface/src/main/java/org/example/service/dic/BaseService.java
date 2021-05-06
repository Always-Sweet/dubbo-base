package org.example.service.dic;

import java.util.List;

public interface BaseService<T> {

    void add(T t);
    void update(T t);
    void delete(String id, String type);
    void batchDelete(List<String> ids, String type);

    T get(String id);
    List<T> getOfPage(Object param, Integer page, Integer size);

}
