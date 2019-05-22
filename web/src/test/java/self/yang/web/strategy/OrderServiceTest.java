package self.yang.web.strategy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * self.yang.web.strategy.OrderServiceTest
 *
 * @author eleven
 * @date 2019/05/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void handle() {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setType("1");

        System.out.println(orderService.handle(orderDTO));

        orderDTO.setType("2");

        System.out.println(orderService.handle(orderDTO));

        orderDTO.setType("3");

        System.out.println(orderService.handle(orderDTO));
    }
}