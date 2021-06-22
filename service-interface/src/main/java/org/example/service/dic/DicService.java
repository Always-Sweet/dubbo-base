package org.example.service.dic;

import org.example.dto.dic.DicDo;
import org.example.dto.dic.DicQuery;
import org.example.dto.dic.DicVo;
import org.example.service.BaseService;

import javax.ws.rs.Path;

@Path("/dic")
public interface DicService extends BaseService<DicDo, DicVo, DicQuery> {

}
