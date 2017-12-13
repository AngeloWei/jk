package cn.zw.jk.dao;


import cn.zw.jk.entity.Factory;

import java.util.Map;

public interface FactoryDao extends BaseDao<Factory>{
     //update产厂家的状态
     boolean updateState(Map map);
}
