package org.yang.boot.scanner;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.annotation.Annotation;

/**
 * org.yang.boot.scanner.MyBeanClassPathDefinitionScanner
 *
 * @author eleven
 * @date 2019/09/06
 */
public class MyBeanClassPathDefinitionScanner extends ClassPathBeanDefinitionScanner {
    private Class type;

    public MyBeanClassPathDefinitionScanner(BeanDefinitionRegistry registry, Class<? extends Annotation> type) {
        super(registry, false);
        this.type = type;
    }

    /**
     * 注册 过滤器
     */
    public void registerTypeFilter() {
        addIncludeFilter(new AnnotationTypeFilter(type));
    }
}
