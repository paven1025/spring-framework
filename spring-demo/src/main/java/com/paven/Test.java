package com.paven;

import com.paven.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.HashMap;

/**
 * @author cpw
 * @date 2021/7/22 12:23 上午
 */
@Configuration
@ComponentScan("com.paven")
public class Test {

    public static void main(String[] args) {
        String name = "paven";
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:/spring/spring-config.xml");
//        TestService testService1 = (TestService) classPathXmlApplicationContext.getBean("testService");
//        testService1.sayHello(name);
//
//        FileSystemXmlApplicationContext fileXmlApplicationContext = new FileSystemXmlApplicationContext("//Users/cpw/source_code/spring-framework/spring-demo/src/main/resources/spring/spring-config.xml");
//        TestService testService2 = (TestService) fileXmlApplicationContext.getBean("testService");
//        testService2.sayHello(name);

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Test.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        TestService testService3 = (TestService) annotationConfigApplicationContext.getBean("testService");
        testService3.sayHello(name);

        // BeanDefinition
    }
}
