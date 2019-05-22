package self.yang.web.strategy;

import org.springframework.stereotype.Component;

/**
 * self.yang.web.strategy.TypeFirstHandler
 *
 * @author eleven
 * @date 2019/05/22
 */
@Component
@HandlerType("1")
public class TypeFirstHandler extends AbstractHandler {
    @Override
    public String handle(OrderDTO orderDTO) {
        return orderDTO.getType() + this.getClass().getSimpleName();
    }
}
