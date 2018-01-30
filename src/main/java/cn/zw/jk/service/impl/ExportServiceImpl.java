package cn.zw.jk.service.impl;

import cn.zw.jk.VOEntity.ContractOV;
import cn.zw.jk.VOEntity.ContractProductOV;
import cn.zw.jk.VOEntity.ExtCProductOV;
import cn.zw.jk.dao.ContractDao;
import cn.zw.jk.dao.ExportDao;
import cn.zw.jk.dao.ExportProductDao;
import cn.zw.jk.dao.ExtEProductDao;
import cn.zw.jk.entity.*;
import cn.zw.jk.service.ExportService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;

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
        map.put("exportId", exportId);
        map.put("state", state);
        exportDao.updateState(map);
    }

    public List<Export> find(Map map) {
        //获取所有的列表
        return exportDao.find(null);
    }

    public Export get(Serializable id) {
        return exportDao.get(id);
    }

    @Transactional
    public void insert(Export entity) {
        //获取报运单中的合同id
        String[] ids = entity.getContractIds().split(",");
        entity.setExportId(UUID.randomUUID().toString().substring(3,8));
        //查询合同号，并以" "为间隔进行拼接
        String exportNo ="";
        if (ids != null) {
            int length = ids.length;
            for (int i = 0; i < length; i++) {

                ContractOV contractOV = contractDao.view(ids[i]);
                if (contractOV != null) {
                    exportNo += contractOV.getContractNo() + " ";
                    //添加报运货物
                    List<ContractProductOV> contractProductOVS = contractOV.getContractProductOVS();
                    if(contractProductOVS!=null) {
                        for (ContractProductOV cp : contractProductOVS
                                ) {
                            //封装exportProduct对象
                            ExportProduct ep = new ExportProduct();
                            ep.setExportId(entity.getExportId());
                            ep.setExportProductId(UUID.randomUUID().toString().substring(3,13));
                            ep.setFactoryId(cp.getFactory().getFactoryId() + "");
                            ep.setFactoryName(cp.getFactory().getFactoryName());
                           // ep.setBoxNum(cp.getBoxNum());
                            ep.setPackingUnit(cp.getPackingUnit());
                            ep.setPrice(cp.getPrice());
                            exportProductDao.insert(ep);
                            List<ExtCProductOV> extCProducts = cp.getExtCProducts();
                                if(extCProducts!=null){
                                    for (ExtCProductOV ecp:extCProducts
                                         ) {
                                        ExtEProduct eep = new ExtEProduct();
                                        BeanUtils.copyProperties(ecp,eep);
                                        eep.setExtEProductId(UUID.randomUUID().toString().substring(3,13));
                                        eep.setExportProductId(ep.getExportProductId());
                                        eep.setFactoryId(ecp.getFactory().getFactoryId()+"");
                                        eep.setFactoryName(ecp.getFactory().getFactoryName());
                                        extEProductDao.insert(eep);
                                    }
                                }
                        }
                    }

                }
            }
            exportNo = exportNo.substring(0, exportNo.length() - 1);
            entity.setCustomerContract(exportNo);
            exportDao.insert(entity);

        }
    }

    @Transactional
    public void update(Export entity) {
        //先更新export信息，再更新exportProduct
        exportDao.update(entity);
        List<ExportProduct> exportProductList = entity.getExportProductList();
        if (null != exportProductList) {
            for (ExportProduct ep : exportProductList
                    ) {
                ep.setExportId(entity.getExportId());
                exportProductDao.update(ep);
            }
        }
    }

    public void deleteById(Serializable id) {
            //先删除报运单下的附件和产品
        Serializable[] ids = {id};
        exportProductDao.deleteByExportId(ids);
        extEProductDao.deleteByExportId(ids);
        //删除报运单
        exportDao.deleteById(id);
    }

    public void delete(Serializable[] ids) {

    }
}
