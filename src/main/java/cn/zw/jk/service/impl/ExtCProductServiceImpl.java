package cn.zw.jk.service.impl;

import cn.zw.jk.dao.ExtCProductDao;
import cn.zw.jk.entity.ExtCProduct;
import cn.zw.jk.entity.SysCode;
import cn.zw.jk.pagination.Page;
import cn.zw.jk.service.ExtCProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ExtCProductServiceImpl implements ExtCProductService {

    @Resource
    private ExtCProductDao extCProductDao;

    public List<ExtCProduct> findPage(Page page) {
        return null;
    }

    public List<ExtCProduct> find(Map map) {
        return extCProductDao.find(map);
    }

    public ExtCProduct get(Serializable id) {
        return extCProductDao.get(id);
    }

    public void insert(ExtCProduct entity) {
        //设置附件id
        entity.setAmount(entity.getCnumber()*entity.getPrice());
        entity.setExtCproductId(UUID.randomUUID().toString().substring(2,10));
        extCProductDao.insert(entity);
    }

    public void update(ExtCProduct entity) {
        entity.setAmount(entity.getCnumber()*entity.getPrice());
        extCProductDao.update(entity);
    }

    public void deleteById(Serializable id) {
        extCProductDao.deleteById(id);
    }

    public void delete(Serializable[] ids) {
        extCProductDao.delete(ids);
    }

    public List<SysCode> getSysCode() {
        return extCProductDao.getSysCode();
    }

    public void deleteByContractProductId(String contractProductId) {
            extCProductDao.deleteByContractProductId(contractProductId);
    }

    public void deleteByContractId(Serializable[] ids) {
            extCProductDao.deleteByContractId(ids);
    }
}
