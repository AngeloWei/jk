package cn.zw.jk.web;


import cn.zw.jk.entity.ContractProduct;
import cn.zw.jk.entity.Factory;
import cn.zw.jk.service.ContractProductService;
import cn.zw.jk.service.FactoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cargo/contractproduct")
public class ContractProductController {
    @Resource
    private ContractProductService contractProductService;
    @Resource
    private  FactoryService factoryService;
    @RequestMapping("/list.action")
    public  String getContractList(String contractId,Model model){
        Map map = new HashMap();
        map.put(contractId,contractId);
        List<ContractProduct> contractProducts = contractProductService.find(map);
        model.addAttribute("dataList",contractProducts);
        return "/cargo/contract/jContractList.jsp" ;
    }
    @RequestMapping("/tocreate.action")
    public String toCreateContract( String contractId, Model model){
        //回显合同号
        model.addAttribute("contractId",contractId);
        //显示合同下的货物信息
        Map map = new HashMap();
        map.put("contractId",contractId);
        List<ContractProduct> contractProducts = contractProductService.find(map);
        model.addAttribute("dataList",contractProducts);
        //获取工厂列表
        Map facotoryMap= new HashMap();
        facotoryMap.put("state",1);
        List<Factory> factoryList = factoryService.find(facotoryMap);
        model.addAttribute("factoryList",factoryList);
        return "/cargo/contract/jContractProductCreate.jsp";
    }
    @RequestMapping("/insert.action")
    public String insertContract(ContractProduct contractProduct){

        contractProductService.insert(contractProduct);
        return "redirect:/cargo/contractproduct/tocreate.action?contractId="+contractProduct.getContractId();
    }
    @RequestMapping("/toupdate.action")
    public String toUpdateContract(String contractProductId,Model model){

        ContractProduct contractProduct = contractProductService.get(contractProductId);  //获取货物信息
        model.addAttribute("obj" ,contractProduct);
        return "/cargo/contract/jContractProductUpdate.jsp" ;
    }
    @RequestMapping("/update.action")
    public String updateContract(ContractProduct contractProduct){
        contractProductService.update(contractProduct);
        return "redirect:/cargo/contractproduct/tocreate.action?contractId="+contractProduct.getContractId();
    }
    @RequestMapping("/deleteById.action")
    public String deleteByIdContract(String contractProductId){
        contractProductService.deleteById(contractProductId);
        return "redirect:/cargo/contract/list.action";
    }

}
