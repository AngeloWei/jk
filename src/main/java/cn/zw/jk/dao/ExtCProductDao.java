package cn.zw.jk.dao;


import cn.zw.jk.entity.ExtCProduct;
import cn.zw.jk.entity.SysCode;

import java.io.Serializable;
import java.util.List;

public interface ExtCProductDao extends BaseDao<ExtCProduct>{
       List<SysCode> getSysCode();
       void deleteByContractProductId(String id);
       void deleteByContractId(Serializable[] ids);
}
