package org.example.service;

import org.example.dto.PageResponse;
import org.example.exception.LogicError;

import java.util.List;

public interface BaseService<DO, VO, QO> {

    /**
     * 返回主键
     * @param t
     * @return
     */
    String add(DO t);
    void update(DO t);
    void delete(String id, String type);
    void batchDelete(List<String> ids, String type);

    VO get(String id) throws LogicError;
    PageResponse<VO> getOfPage(QO param) throws LogicError;

}
