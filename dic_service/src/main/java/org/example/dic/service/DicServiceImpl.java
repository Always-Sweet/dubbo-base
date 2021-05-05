package org.example.dic.service;

import org.example.dic.dao.DicDao;
import org.example.model.Dic;
import org.example.service.dic.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dicService")
public class DicServiceImpl implements DicService {

    @Autowired
    DicDao dicDao;

    @Override
    public void add(Dic dic) {

    }

    @Override
    public void update(Dic dic) {

    }

    @Override
    public void delete(String id, String type) {

    }

    @Override
    public void batchDelete(String[] ids, String type) {

    }

    @Override
    public Dic get(String id) {
        return dicDao.get(id);
    }

    @Override
    public List<Dic> getOfPage(Integer page, Integer size) {
        return null;
    }

}
