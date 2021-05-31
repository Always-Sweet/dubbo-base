package org.example.service;

import java.util.List;

public interface BaseService<DO, VO, QO> {

    String add(DO t);
    void update(DO t);
    void delete(String id, String type);
    void batchDelete(List<String> ids, String type);

    VO get(String id);
    List<VO> getOfPage(QO param);

}
