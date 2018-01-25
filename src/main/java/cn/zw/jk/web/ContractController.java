package cn.zw.jk.web;

import cn.zw.jk.VOEntity.ContractOV;
import cn.zw.jk.entity.Contract;
import cn.zw.jk.service.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import java.util.List;

@Controller
public class ContractController {
    @Resource
    private ContractService contractService;

    @RequestMapping("/cargo/contract/list.action")
    public  String getContractList(Model model){
        List<Contract> contracts = contractService.find(null);
        model.addAttribute("dataList",contracts);
        return "/cargo/contract/jContractList.jsp" ;
    }
    @RequestMapping("/cargo/contract/tocreate.action")
    public String toCreateContract(){
        return "/cargo/contract/jContractCreate.jsp";
    }
    @RequestMapping("/cargo/contract/insert.action")
    public String insertContract(Contract contract){
        contractService.insert(contract);
        return "redirect:/cargo/contract/list.action";
    }
    @RequestMapping("/cargo/contract/toupdate.action")
    public String toUpdateContract(String id,Model model){
        Contract contract = contractService.get(id);
        model.addAttribute("obj" ,contract);
        return "/cargo/contract/jContractUpdate.jsp" ;
    }
    @RequestMapping("/cargo/contract/update.action")
    public String updateContract(String id,Contract contract){
        contract.setContractId(id);
        contractService.update(contract);
        return "redirect:/cargo/contract/list.action" ;
    }
    @RequestMapping("/cargo/contract/delete.action")
    public String deleteByIdContract(String[] id){
        contractService.delete(id);
        return "redirect:/cargo/contract/list.action";
    }
    //合同详情查看
    @RequestMapping("/cargo/contract/toview.action")
    public String viewContract(String id ,Model model){
        ContractOV contractOV = contractService.view(id);
        model.addAttribute("obj",contractOV);
        return "/cargo/contract/jContractView.jsp";
    }
}
