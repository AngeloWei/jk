package cn.zw.jk.dao;


import cn.zw.jk.entity.Contract;

import java.util.Map;

public interface ContractDao extends BaseDao<Contract>{
    void updateState(Map map);
}
