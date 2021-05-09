package org.example.dic.service;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.example.Constant;
import org.example.dic.dao.DicDao;
import org.example.dto.dic.DicDo;
import org.example.dto.dic.DicQuery;
import org.example.dic.model.Dic;
import org.example.dto.dic.DicVo;
import org.example.service.dic.DicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service("dicService")
public class DicServiceImpl implements DicService {

    @Autowired
    DicDao dicDao;

    @Override
    @Transactional
    public void add(@Validated DicDo dicDo) {
        Dic search = dicDao.getById(dicDo.getDicCode());
        // 如果非空则已存在，不能重复创建
        if (search != null) {
            // throw error
        }

        dicDo.setDicId(UUID.randomUUID().toString());
        Dic dic = new Dic();
        BeanUtils.copyProperties(dicDo, dic);
        dic.setFgDelete(Constant.FG.NO_0);
        dicDao.save(dic);
        System.out.println("字典添加成功……");
    }

    @Override
    @Transactional
    public void update(@Validated DicDo dicDo) {
        Dic search = dicDao.getById(dicDo.getDicId());
        // 如果为空则不存在，无法更新
        if (search == null) {
            // throw error
        }

        BeanUtils.copyProperties(dicDo, search);
        dicDao.save(search);
        System.out.println("字典更新成功……");
    }

    @Override
    @Transactional
    public void delete(String id, String type) {
        if (StringUtils.isEmpty(id)) {
            // 入参确实
        }
        Dic search = dicDao.getById(id);
        // 如果为空则不存在，不能执行删除操作
        if (search == null) {
            // 删除对象不存在
        }

        if (Constant.DELETE_TYPE.HARD_1.equals(type)) {
            dicDao.delete(search);
        } else {
            // 更新删除标识
            search.setFgDelete(Constant.FG.YES_1);
            dicDao.save(search);
        }
        System.out.println("字典删除成功……");
    }

    @Override
    @Transactional
    public void batchDelete(List<String> ids, String type) {
        if (CollectionUtils.isEmpty(ids)) {
            // 批量删除主键集合为空
        }

        if (Constant.DELETE_TYPE.HARD_1.equals(type)) {
            dicDao.deleteAllByIdInBatch(ids);
        } else {
            for (String id : ids) {
                this.delete(id, type);
            }
        }
        System.out.println("字典批量删除成功……");
    }

    @Override
    @Transactional(readOnly = true)
    public DicVo get(String id) {
        if (StringUtils.isEmpty(id)) {
            // throw error
        }

        Dic search = dicDao.getById(id);
        DicVo dicVo = new DicVo();
        BeanUtils.copyProperties(search, dicVo);
        System.out.println("字典查询：" + dicVo.toString());
        return dicVo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DicVo> getOfPage(DicQuery paramDto, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<Dic> specification = (Specification<Dic>) (root, query, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            Predicate p = null;
            if (StringUtils.isNotEmpty(paramDto.getDicCode())) {
                p = criteriaBuilder.like(root.get("dicCode"), paramDto.getDicCode());
                list.add(p);
            }
            if (StringUtils.isNotEmpty(paramDto.getDicName())) {
                p = criteriaBuilder.like(root.get("dicName"), "%" + paramDto.getDicName() + "%");
                list.add(p);
            }
            return criteriaBuilder.and(list.toArray(new Predicate[0]));
        };
        List<Dic> search =  dicDao.findAll(specification, pageable).toList();
        return search.stream().map(dicDo -> {
            DicVo dicVo = new DicVo();
            BeanUtils.copyProperties(dicDo, dicVo);
            return dicVo;
        }).collect(Collectors.toList());
    }



}
