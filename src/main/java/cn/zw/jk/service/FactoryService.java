package cn.zw.jk.service;



import cn.zw.jk.entity.Factory;
import cn.zw.jk.pagination.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface FactoryService {

    List<Factory> findPage(Page page );//分页查询

    List<Factory> find(Map map);//带条件查询,条件可以是null,返回list集合

    Factory get(Serializable id);//只查询一个,常用于修改

    void insert(Factory entity); //插入一个对象

    void update(Factory entity);//修改一个对象

    void deleteById(Serializable id); //根据id删除数据,支持整形和字符串类型id

    void delete(Serializable[] ids);//批量删除

    boolean updateState(Map map);  //修改状态


}
