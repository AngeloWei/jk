package cn.zw.jk.dao;

import cn.zw.jk.entity.ContractProduct;
import cn.zw.jk.entity.Export;
import cn.zw.jk.entity.ExportProduct;

import java.io.Serializable;

public interface ExportProductDao extends BaseDao<ExportProduct>{
    void deleteByExportId(Serializable[] ids);
}
