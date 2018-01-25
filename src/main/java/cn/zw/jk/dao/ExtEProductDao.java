package cn.zw.jk.dao;


import cn.zw.jk.entity.ExtCProduct;
import cn.zw.jk.entity.ExtEProduct;
import cn.zw.jk.entity.SysCode;

import java.io.Serializable;
import java.util.List;

public interface ExtEProductDao extends BaseDao<ExtEProduct>{

       void deleteByContractProductId(String id);
       void deleteByExportId(Serializable[] ids);
}
