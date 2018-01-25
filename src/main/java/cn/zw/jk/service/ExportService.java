package cn.zw.jk.service;

import cn.zw.jk.entity.Export;

public interface ExportService  extends BaseService<Export>{
    void updateState(String exportId,short state);
}
