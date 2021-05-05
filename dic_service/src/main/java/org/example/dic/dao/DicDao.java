package org.example.dic.dao;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.example.Constant;
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
        entityManager.persist(dic);
    }

    @Override
    public void update(Dic dic) {
        entityManager.merge(dic);
    }

    @Override
    public void delete(Dic dic, String type) {
        if (dic == null || StringUtils.isEmpty(dic.getDicId())) {
            // throw error
        }
        if (StringUtils.isEmpty(type) || Constant.DELETE_TYPE.SOFT_0.equals(type)) {
            // 确保更新时不更新其他字段
            Dic search = this.get(dic.getDicId());
            // 更新删除标识
            search.setFgDelete(Constant.FG.YES_1);
            this.update(search);
        }
        entityManager.remove(dic);
    }

    @Override
    public void batchDelete(List<Dic> dics, String type) {
        if (CollectionUtils.isEmpty(dics)) {
            // throw error
        }
        if (StringUtils.isEmpty(type) || Constant.DELETE_TYPE.SOFT_0.equals(type)) {
            List<Dic> search = entityManager.createNativeQuery(" select * from Dic where ids in :(ids) ")
                    .setParameter("ids", dics)
                    .getResultList();
            for (Dic dic : search) {
                this.delete(dic, Constant.DELETE_TYPE.SOFT_0);
            }
        }
        for (Dic dic : dics) {
            this.delete(dic, type);
        }
    }

    @Override
    public Dic get(String id) {
        return entityManager.find(Dic.class, id);
    }

    public List<Dic> getByIds(List<String> ids) {
        return entityManager.createNativeQuery(" select * from dic where id in :(ids) ")
                .setParameter("ids", ids)
                .getResultList();
    }

    public Dic findByCode(String code) {
        List<Dic> search = entityManager.createQuery(" from Dic where dicCode = :code ")
                .setParameter("code", code)
                .getResultList();
        if (CollectionUtils.isEmpty(search)) {
            return null;
        } else if (search.size() > 1) {
            // throw error
        }
        return search.get(0);
    }

    @Override
    public List<Dic> getOfPage(Integer page, Integer size) {
        return null;
    }
}
