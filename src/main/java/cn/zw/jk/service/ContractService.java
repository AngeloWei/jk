package cn.zw.jk.service;

import cn.zw.jk.entity.Contract;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ContractService {

    void insert(Contract contract);
    List<Contract> find (Map map);
    void deleteById(Serializable id);
    void delete(Serializable[] ids);
    Contract get(Serializable id);

    void  update(Contract contract);
    void  updateState(Map map);
}