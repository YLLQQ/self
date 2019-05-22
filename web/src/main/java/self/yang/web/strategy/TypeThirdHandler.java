package self.yang.web.strategy;

import org.springframework.stereotype.Component;

/**
 * self.yang.web.strategy.TypeThirdHandler
 *
 * @author eleven
 * @date 2019/05/22
 */
@Component
@HandlerType("3")
public class TypeThirdHandler extends AbstractHandler {
    @Override
    public String handle(OrderDTO orderDTO) {
        return orderDTO.getType() + this.getClass().getSimpleName();
    }
}
