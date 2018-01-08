package cn.zw.jk.dao;

import cn.zw.jk.entity.ContractProduct;

import java.io.Serializable;

public interface ContractProductDao extends BaseDao<ContractProduct>{
    void deleteByContractId(Serializable[] ids);
}
