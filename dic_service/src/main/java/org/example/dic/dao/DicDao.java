package org.example.dic.dao;

import org.example.model.Dic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DicDao extends JpaRepository<Dic, String>, JpaSpecificationExecutor<Dic> {

}
