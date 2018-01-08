package cn.zw.jk.service;

import cn.zw.jk.entity.ExtCProduct;
import cn.zw.jk.entity.SysCode;

import java.io.Serializable;
import java.util.List;

public interface ExtCProductService extends BaseService<ExtCProduct>{

    List<SysCode> getSysCode();
    void deleteByContractProductId(String contractProductId);
    void deleteByContractId(Serializable[] ids);
}
