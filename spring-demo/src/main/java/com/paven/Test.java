package com.paven;

import com.paven.service.TestService1;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author cpw
 * @date 2021/7/22 12:23 上午a
 */
@Configuration
@ComponentScan("com.paven")
public class Test {

    public static void main(String[] args) {
        String name = "paven";

        //XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("classpath:/spring/spring-config.xml"));

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:/spring/spring-config.xml");
        String[] definitionNames = classPathXmlApplicationContext.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println(definitionName);
        }
        TestService1 testService1 = (TestService1) classPathXmlApplicationContext.getBean("testService1");
        testService1.sayHello(name);

//        FileSystemXmlApplicationContext fileXmlApplicationContext = new FileSystemXmlApplicationContext("//Users/cpw/source_code/spring-framework/spring-demo/src/main/resources/spring/spring-config.xml");
//        TestService testService2 = (TestService) fileXmlApplicationContext.getBean("testService");
//        testService2.sayHello(name);

//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Test.class);
//        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }
//        TestService testService3 = (TestService) annotationConfigApplicationContext.getBean("testService");
//        testService3.sayHello(name);

        // BeanDefinition
    }
}
