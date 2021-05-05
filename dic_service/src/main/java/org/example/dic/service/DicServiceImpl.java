package org.example.dic.service;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.example.dic.dao.DicDao;
import org.example.model.Dic;
import org.example.service.dic.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Service("dicService")
public class DicServiceImpl implements DicService {

    @Autowired
    DicDao dicDao;

    @Override
    @Transactional
    public void add(@Validated Dic dic) {
        Dic search = dicDao.findByCode(dic.getDicCode());
        // 如果非空则已存在，不能重复创建
        if (search != null) {
            // throw error
        }

        dic.setDicId(UUID.randomUUID().toString());
        dicDao.save(dic);
        System.out.println("字典添加成功……");
    }

    @Override
    @Transactional
    public void update(Dic dic) {
        Dic search = dicDao.get(dic.getDicId());
        // 如果为空则不存在，无法更新
        if (search == null) {
            // throw error
        }

        dicDao.update(dic);
        System.out.println("字典更新成功……");
    }

    @Override
    @Transactional
    public void delete(String id, String type) {
        if (StringUtils.isEmpty(id)) {
            // 入参确实
        }
        Dic search = dicDao.get(id);
        // 如果为空则不存在，不能执行删除操作
        if (search == null) {
            // 删除对象不存在
        }

        dicDao.delete(search, type);
        System.out.println("字典更新成功……");
    }

    @Override
    @Transactional
    public void batchDelete(List<String> ids, String type) {
        if (CollectionUtils.isEmpty(ids)) {
            // 批量删除主键集合为空
        }
        List<Dic> search = dicDao.getByIds(ids);
        // 主键集合查询为空，
        if (CollectionUtils.isEmpty(search)) {
            // 未查询到相关对象
        }

        dicDao.batchDelete(search, type);
        System.out.println("字典更新成功……");
    }

    @Override
    public Dic get(String id) {
        if (StringUtils.isEmpty(id)) {
            // throw error
        }
        Dic search = dicDao.get(id);
        System.out.println("字典查询：" + search.toString());
        return search;
    }

    @Override
    public List<Dic> getOfPage(Integer page, Integer size) {
        return null;
    }

}
