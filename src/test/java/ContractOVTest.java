
import cn.zw.jk.entity.ContractProduct;
import cn.zw.jk.entity.Export;
import cn.zw.jk.entity.ExportProduct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class ContractOVTest {

    //@Resource
   // private ContractService contractService;

    @Test
    public void testContractView(){
        //ContractOV view = contractService.view("6bf43-3032-4915");
        String exportNum="";

        System.out.println(exportNum);
    }
}
