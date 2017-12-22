package cn.zw.jk.service;

import cn.zw.jk.pagination.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseService<T>{


     List<T> find(Map map);//带条件查询,条件可以是null,返回list集合

     T get(Serializable id);//只查询一个,常用于修改

      void insert(T entity); //插入一个对象

      void update(T entity);//修改一个对象

     void deleteById(Serializable id); //根据id删除数据,支持整形和字符串类型id

     void delete(Serializable[] ids);//批量删除

}
