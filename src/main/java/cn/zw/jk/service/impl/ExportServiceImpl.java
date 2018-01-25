package cn.zw.jk.service.impl;

import cn.zw.jk.dao.ContractDao;
import cn.zw.jk.dao.ExportDao;
import cn.zw.jk.dao.ExportProductDao;
import cn.zw.jk.dao.ExtEProductDao;
import cn.zw.jk.entity.Contract;
import cn.zw.jk.entity.Export;
import cn.zw.jk.service.ExportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExportServiceImpl implements ExportService {
    @Resource
    private ExportDao exportDao;
    @Resource
    private ContractDao contractDao;
    @Resource
    private ExportProductDao exportProductDao;
    @Resource
    private ExtEProductDao extEProductDao;

    public void updateState(String exportId, short state) {
            Map map = new HashMap();
            map.put("exportId",exportId);
            map.put("state",state);
            exportDao.updateState(map);
    }

    public List<Export> find(Map map) {
        //获取所有的列表
        return exportDao.find(null);
    }

    public Export get(Serializable id) {
        return exportDao.get(id);
    }

    public void insert(Export entity) {
        //获取报运单中的合同id
        String[] ids = entity.getContractIds().split(",");
        //查询合同号，并以" "为间隔进行拼接
        String exportNo =null;
        if(ids !=null){
            int length = ids.length;
            for (int i =0;i<length;i++){
                Contract contract = contractDao.get(ids[i]);
                exportNo += contract.getContractNo()+" ";
            }
            exportNo = exportNo.substring(0,exportNo.length()-1);
            entity.setCustomerContract(exportNo);
        }
    }

    public void update(Export entity) {

    }

    public void deleteById(Serializable id) {

    }

    public void delete(Serializable[] ids) {

    }
}
