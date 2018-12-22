package self.yang.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import self.yang.web.dos.SecondKillConfigDO;
import self.yang.web.services.SecondKillConfigMapperService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecondKillConfigTests {

    @Autowired
    private SecondKillConfigMapperService secondKillConfigMapperService;

    @Test
    public void testDeleteSecondKillConfigDO() {
        boolean result = secondKillConfigMapperService.deleteSecondKillConfigDO(1);

        System.out.println(result);
    }

    @Test
    public void testSecondKillConfigDO() {
        SecondKillConfigDO secondKillConfigDO = secondKillConfigMapperService.getSecondKillConfigDO(1);

        System.out.println(secondKillConfigDO);
    }

    @Test
    public void testSecondKillConfigDOWithPage() {
        ArrayList<SecondKillConfigDO> secondKillConfigDOList = secondKillConfigMapperService.getSecondKillConfigDOWithPage(1, 6);

        secondKillConfigDOList.stream().forEach(System.out::println);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        secondKillConfigDOList = secondKillConfigMapperService.getSecondKillConfigDOWithPage(2, 6);

        secondKillConfigDOList.stream().forEach(System.out::println);
    }

    @Test
    public void testAllSecondKillConfigDO() {
        ArrayList<SecondKillConfigDO> secondKillConfigDOList = secondKillConfigMapperService.getAllSecondKillConfigDO();

        secondKillConfigDOList.stream().forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        SecondKillConfigDO secondKillConfigDO = new SecondKillConfigDO();

        secondKillConfigDO.setKillProductId((int) (Math.random() * 100));
        secondKillConfigDO.setKillProductStock(100);

        boolean result = secondKillConfigMapperService.addSecondKillConfig(secondKillConfigDO);

        System.out.println(result);
    }

}

