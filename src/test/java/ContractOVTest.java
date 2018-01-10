import cn.zw.jk.VOEntity.ContractOV;
import cn.zw.jk.service.ContractService;

import javax.annotation.Resource;

public class ContractOVTest {

    @Resource
    private ContractService contractService;

    public void testContractView(){
        ContractOV view = contractService.view();
    }
}
