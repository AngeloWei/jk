package cn.zw.jk.service;

import cn.zw.jk.entity.Contract;
import cn.zw.jk.entity.ContractProduct;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ContractProductService {
    void insert(ContractProduct contractProduct);
    List<ContractProduct> find (Map map);
    void deleteById(Serializable id);
    void delete(Serializable[] ids);
    ContractProduct get(Serializable id);
    void  update(ContractProduct contractProduct);
    //void  updateState(Map map);
}
