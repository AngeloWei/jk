package cn.zw.jk.service.impl;

import cn.zw.jk.dao.ContractProductDao;

import cn.zw.jk.entity.ContractProduct;
import cn.zw.jk.service.ContractProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ContractProductServiceImpl  implements ContractProductService{
    @Resource
    private ContractProductDao contractProductDao;

    public void insert(ContractProduct contractProduct) {
            //设置货物Id
            contractProduct.setContractProductId(UUID.randomUUID().toString().substring(3,18));
            contractProductDao.insert(contractProduct);
    }

    public List<ContractProduct> find(Map map) {
        //查询某个合同下的所有获取
        return contractProductDao.find(map);
    }

    public void deleteById(Serializable id) {
        contractProductDao.deleteById(id);
    }

    public void delete(Serializable[] ids) {
        contractProductDao.delete(ids);
    }

    public ContractProduct get(Serializable id) {
        return contractProductDao.get(id);
    }

    public void update(ContractProduct contractProduct) {
        contractProductDao.update(contractProduct);
    }
}
