package cn.zw.jk.dao;


import cn.zw.jk.VOEntity.ContractOV;
import cn.zw.jk.entity.Contract;
import cn.zw.jk.entity.Export;

import java.util.Map;

public interface ExportDao extends BaseDao<Export>{
    void updateState(Map map);              //修改报运单状态
}
