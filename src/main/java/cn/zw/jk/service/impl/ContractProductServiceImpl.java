package cn.zw.jk.service.impl;

import cn.zw.jk.dao.ContractProductDao;

import cn.zw.jk.dao.ExtCProductDao;
import cn.zw.jk.entity.ContractProduct;
import cn.zw.jk.service.ContractProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ContractProductServiceImpl  implements ContractProductService{
    @Resource
    private ContractProductDao contractProductDao;
    @Resource
    private ExtCProductDao extCProductDao;

    public void insert(ContractProduct contractProduct) {
            //设置货物Id
            contractProduct.setAmount(contractProduct.getPrice()*contractProduct.getCnumber());
            contractProduct.setContractProductId(UUID.randomUUID().toString().substring(3,18));
            contractProductDao.insert(contractProduct);
    }

    public List<ContractProduct> find(Map map) {
        //查询某个合同下的所有获取
        return contractProductDao.find(map);
    }
    @Transactional
    public void deleteById(Serializable id) {
        //查询货物Id下的附件，删除附件，再删除货物
        extCProductDao.deleteByContractProductId(id.toString());
        contractProductDao.deleteById(id);
    }

    public void delete(Serializable[] ids) {
        contractProductDao.delete(ids);
    }

    public ContractProduct get(Serializable id) {
        return contractProductDao.get(id);
    }

    public void update(ContractProduct contractProduct) {
        contractProduct.setAmount(contractProduct.getPrice()*contractProduct.getCnumber());
        contractProductDao.update(contractProduct);
    }

    public void deleteByContarctId(Serializable[] ids) {
        contractProductDao.deleteByContractId(ids);
    }
}
