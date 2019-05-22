package self.yang.web.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.yang.web.strategy.base.HandlerContext;

/**
 * 参考链接：https://blog.csdn.net/kisscatforever/article/details/89432158
 * <p>
 * self.yang.web.strategy.OrderService
 *
 * @author eleven
 * @date 2019/05/22
 */
@Service
public class OrderService {

    @Autowired
    private HandlerContext handlerContext;

    public String handle(OrderDTO orderDTO) {
        AbstractHandler instance = handlerContext.getInstance(orderDTO.getType());

        return instance.handle(orderDTO);
    }


}
