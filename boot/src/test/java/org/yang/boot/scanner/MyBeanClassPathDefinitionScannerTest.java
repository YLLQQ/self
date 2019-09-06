package org.yang.boot.scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.yang.boot.annotation.MyBean;

/**
 * org.yang.boot.scanner.MyBeanClassPathDefinitionScannerTest
 *
 * @author eleven
 * @date 2019/09/06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBeanClassPathDefinitionScannerTest {

    @Test
    public void testSimpleScan() {
        String BASE_PACKAGE = "org.yang.boot";

        GenericApplicationContext context = new GenericApplicationContext();
        MyBeanClassPathDefinitionScanner myBeanClassPathDefinitionScanner = new MyBeanClassPathDefinitionScanner(
                context, MyBean.class);

        myBeanClassPathDefinitionScanner.registerTypeFilter();
        int beanCount = myBeanClassPathDefinitionScanner.scan(BASE_PACKAGE);
        context.refresh();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        System.out.println(beanCount);

        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }


}