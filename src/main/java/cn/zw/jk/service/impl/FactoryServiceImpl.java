package cn.zw.jk.service.impl;

import cn.zw.jk.dao.FactoryDao;
import cn.zw.jk.entity.Factory;
import cn.zw.jk.pagination.Page;
import cn.zw.jk.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FactoryServiceImpl implements FactoryService {

    @Autowired
    private FactoryDao factoryDao;


    public List<Factory> findPage(Page page) {
        return null;
    }

    public List<Factory> find(Map map) {
        return factoryDao.find(map);
    }

    public Factory get(Serializable id) {
        return factoryDao.get(id);
    }

    public void insert(Factory entity) {
        entity.setState(1);
        factoryDao.insert(entity);
    }

    public void update(Factory entity) {
            factoryDao.update(entity);
    }



    public void deleteById(Serializable id) {
            factoryDao.deleteById(id);
    }

    public void delete(Serializable[] ids) {
            factoryDao.delete(ids);
    }

    public boolean updateState(Map map) {
        return factoryDao.updateState(map);
    }
}
