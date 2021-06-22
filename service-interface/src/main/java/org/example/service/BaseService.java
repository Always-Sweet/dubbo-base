package org.example.service;

import org.example.exception.LogicError;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

public interface BaseService<DO, VO, QO> {

    @Path("")
    @POST
//    @Produces({MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8"})
    @Consumes({MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8"})
    String add(DO t);
    void update(DO t);
    void delete(String id, String type);
    void batchDelete(List<String> ids, String type);

    VO get(String id) throws LogicError;
    List<VO> getOfPage(QO param);

}
