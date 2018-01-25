import cn.zw.jk.VOEntity.ContractOV;
import cn.zw.jk.service.ContractService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class ContractOVTest {

    @Resource
    private ContractService contractService;

    @Test
    public void testContractView(){
        ContractOV view = contractService.view("6bf43-3032-4915");
    }
}
