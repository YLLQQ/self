package self.yang.web.strategy.base;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import self.yang.web.strategy.HandlerType;

import java.util.Map;

/**
 * self.yang.web.strategy.base.HandlerProcessor
 *
 * @author eleven
 * @date 2019/05/22
 */
@Component
@SuppressWarnings("unchecked")
public class HandlerProcessor implements BeanFactoryPostProcessor {

    private static final String HANDLER_PACKAGE = "self.yang.web.strategy";

    /**
     * 扫描@HandlerType，初始化HandlerContext，将其注册到spring容器
     *
     * @param beanFactory bean工厂
     * @see HandlerType
     * @see HandlerContext
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, Class> handlerMap = Maps.newHashMapWithExpectedSize(3);

        ClassScaner.scan(HANDLER_PACKAGE, HandlerType.class).forEach(clazz -> {
            String type = clazz.getAnnotation(HandlerType.class).value();

            handlerMap.put(type, clazz);
        });

        HandlerContext context = new HandlerContext(handlerMap);

        beanFactory.registerSingleton(HandlerContext.class.getName(), context);
    }

}

