package cn.zw.jk.service.impl;

import cn.zw.jk.dao.ContractDao;
import cn.zw.jk.entity.Contract;
import cn.zw.jk.service.ContractService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ContractServiceImpl implements ContractService {
    @Resource
    private ContractDao contractDao;

    public void insert(Contract contract) {
        contract.setContractId(UUID.randomUUID().toString().substring(3,18));
        contractDao.insert(contract);
    }

    public List<Contract> find(Map map) {
        return contractDao.find(map);
    }

    public void deleteById(Serializable id) {
        contractDao.deleteById(id);
    }

    public void delete(Serializable[] ids) {
        contractDao.delete(ids);
    }

    public Contract get(Serializable id) {
        return contractDao.get(id);
    }

    public void update(Contract contract) {
        contractDao.update(contract);
    }

    public void updateState(Map map) {
        contractDao.updateState(map);
    }
}
