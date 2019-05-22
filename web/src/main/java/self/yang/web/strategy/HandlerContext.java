package self.yang.web.strategy;

import java.util.Map;

/**
 * self.yang.web.strategy.HandlerContext
 *
 * @author eleven
 * @date 2019/05/22
 */
public class HandlerContext {

    private Map<String, Class> handlerMap;

    public HandlerContext(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public AbstractHandler getInstance(String type) {
        Class aClass = handlerMap.get(type);

        if (null == aClass) {
            throw new IllegalArgumentException("not found handler for type: " + type);
        }

        return (AbstractHandler) BeanTool.getBean(aClass);

    }
}
