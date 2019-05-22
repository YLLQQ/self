package self.yang.web.strategy.base;

import self.yang.web.strategy.AbstractHandler;

import java.util.Map;

/**
 * self.yang.web.strategy.base.HandlerContext
 *
 * @author eleven
 * @date 2019/05/22
 */
@SuppressWarnings("unchecked")
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
