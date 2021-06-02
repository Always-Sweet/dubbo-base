package org.example.dic.dao;

import org.example.dic.model.Dic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author 章春波
 * @date 2021/6/1 15:50
 * @ClassName: DicDao
 * @Description: 字典数据访问层
 */
@Repository
public interface DicDao extends JpaRepository<Dic, String>, JpaSpecificationExecutor<Dic> {

}
