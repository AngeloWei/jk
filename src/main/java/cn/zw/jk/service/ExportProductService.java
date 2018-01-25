package cn.zw.jk.service;

import cn.zw.jk.entity.ContractProduct;
import cn.zw.jk.entity.ExportProduct;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ExportProductService extends BaseService<ExportProduct>{
    //void  updateState(Map map);
    void  deleteByExportId(Serializable[] ids);
}
