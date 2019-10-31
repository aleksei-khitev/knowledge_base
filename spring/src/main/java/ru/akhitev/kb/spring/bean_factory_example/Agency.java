package ru.akhitev.kb.spring.bean_factory_example;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class Agency {
    private static final String XML_CONFIG = "spring/bean-factory-example-cfg.xml";

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(factory);
        beanDefinitionReader.loadBeanDefinitions(new ClassPathResource(XML_CONFIG));
        BountyHunter bountyHunter = factory.getBean("Boba Fet", BountyHunter.class);
        System.out.println(bountyHunter.status());
    }
}
