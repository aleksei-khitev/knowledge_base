package ru.akhitev.kb.spring.bean_factory_example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class Agency {
    private static final String XML_CONFIG = "spring/bean_factory_example/bean-factory-example-cfg.xml";

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(factory);
        beanDefinitionReader.loadBeanDefinitions(new ClassPathResource(XML_CONFIG));
        String bean = "Boba Fet";
        BountyHunter bountyHunter = factory.getBean(bean, BountyHunter.class);
        System.out.println(bountyHunter.status());
        readBeanDefinition(factory, bean);
    }

    private static void readBeanDefinition(DefaultListableBeanFactory factory, String bean) {
        BeanDefinition definition = factory.getBeanDefinition(bean);
        System.out.println(definition);
    }
}
