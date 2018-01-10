package cn.zw.jk.service.impl;

import cn.zw.jk.VOEntity.ContractOV;
import cn.zw.jk.dao.ContractDao;
import cn.zw.jk.dao.ContractProductDao;
import cn.zw.jk.dao.ExtCProductDao;
import cn.zw.jk.entity.Contract;
import cn.zw.jk.entity.ExtCProduct;
import cn.zw.jk.service.ContractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@Service
public class ContractServiceImpl implements ContractService {
    @Resource
    private ContractDao contractDao;
    @Resource
    private ExtCProductDao extCProductDao;
    @Resource
    private ContractProductDao contractProductDao;

    public void insert(Contract contract) {

        contract.setContractId(UUID.randomUUID().toString().substring(3,18));
        contract.setOldState(1);
        contract.setState(1);
        contractDao.insert(contract);
    }

    public List<Contract> find(Map map) {
        return contractDao.find(map);
    }

    public void deleteById(Serializable id) {
        Serializable[] ids = {id};
        extCProductDao.deleteByContractId(ids);
        contractProductDao.deleteByContractId(ids);
        contractDao.deleteById(id);
    }

    public void delete(Serializable[] ids) {
        extCProductDao.deleteByContractId(ids);
        contractProductDao.deleteByContractId(ids);
        contractDao.delete(ids);
    }

    public Contract get(Serializable id) {
        return contractDao.get(id);
    }

    public ContractOV view() {
        return contractDao.view();
    }

    public void update(Contract contract) {
        contractDao.update(contract);
    }

    public void updateState(Map map) {
        contractDao.updateState(map);
    }
}
