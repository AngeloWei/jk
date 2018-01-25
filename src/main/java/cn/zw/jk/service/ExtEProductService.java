package cn.zw.jk.service;

import cn.zw.jk.entity.ExtCProduct;
import cn.zw.jk.entity.ExtEProduct;
import cn.zw.jk.entity.SysCode;

import java.io.Serializable;
import java.util.List;

public interface ExtEProductService extends BaseService<ExtEProduct>{

    void deleteByExportProductId(String id);
    void deleteByExportId(Serializable[] ids);
}
