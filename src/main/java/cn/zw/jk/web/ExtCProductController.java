package cn.zw.jk.web;


import cn.zw.jk.entity.ContractProduct;
import cn.zw.jk.entity.ExtCProduct;
import cn.zw.jk.entity.Factory;
import cn.zw.jk.entity.SysCode;
import cn.zw.jk.service.ContractProductService;
import cn.zw.jk.service.ExtCProductService;
import cn.zw.jk.service.FactoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cargo/extcproduct")
public class ExtCProductController {
    private  static final Map map = new HashMap();
    static {
        map.put("state",1);
    }

    @Resource
    private ExtCProductService extCProductService;
    @Resource
    private  FactoryService factoryService;
    @RequestMapping("/list.action")
    public  String getContractList(String contractProductId,Model model){
        Map map = new HashMap();
        map.put(contractProductId,contractProductId);
        List<ExtCProduct> contractProducts = extCProductService.find(map);
        model.addAttribute("dataList",contractProducts);
        return "/cargo/contract/jContractList.jsp" ;
    }
    @RequestMapping("/tocreate.action")
    public String toCreateContract( String contractProductId, Model model){
        //回显合同号
        model.addAttribute("contractProductId",contractProductId);
        //显示货物下的附件信息
        Map mapId = new HashMap();
        mapId.put("contractProductId",contractProductId);
        List<ExtCProduct> contractProducts = extCProductService.find(mapId);
        model.addAttribute("dataList",contractProducts);
        //获取工厂列表
        List<Factory> factoryList = factoryService.find(map);
        model.addAttribute("factoryList",factoryList);
        //显示附件type
        List<SysCode> sysCode = extCProductService.getSysCode();
        model.addAttribute("ctypeList",sysCode);
        return "/cargo/contract/jExtCproductCreate.jsp";
    }
    @RequestMapping("/insert.action")
    public String insertContract(ExtCProduct extCProduct){

        extCProductService.insert(extCProduct);
        return "redirect:/cargo/extcproduct/tocreate.action?contractProductId="+extCProduct.getContractProductId();
    }
    @RequestMapping("/toupdate.action")
    public String toUpdateContract(String id,Model model){
        //获取工厂List
        List<Factory> factoryList = factoryService.find(map);
        model.addAttribute("factoryList",factoryList);

        ExtCProduct extCProduct = extCProductService.get(id);  //获取附件信息
        model.addAttribute("obj" ,extCProduct);
        //获取附件type
        List<SysCode> sysCode = extCProductService.getSysCode();
        model.addAttribute("ctypeList",sysCode);
        return "/cargo/contract/jExtCproductUpdate.jsp" ;
    }
    @RequestMapping("/update.action")
    public String updateContract(ExtCProduct extCProduct,Model model){
        extCProductService.update(extCProduct);

        return "redirect:/cargo/extcproduct/tocreate.action?contractProductId="+extCProduct.getContractProductId();
    }
    @RequestMapping("/deleteById.action")
    public String deleteByIdContract(String id){
        extCProductService.deleteById(id);
        return "redirect:/cargo/contract/list.action";
    }

}
