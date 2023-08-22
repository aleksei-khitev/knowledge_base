package ru.akhitev.kb.spring.component_scan_xml_example;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.akhitev.kb.spring.component_scan_xml_example.ships.*;

public class MobileGroupXmlConfig {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/component_scan_xml_example/beans.xml");
        context.refresh();
        isShipIncluded(context, Agamemnon.class);
        isShipIncluded(context, Rage.class);
        isShipIncluded(context, Victory.class);
        context.close();
    }

    private static void isShipIncluded(ApplicationContext context, Class<? extends MilitaryShip> className) {
        try {
            MilitaryShip ship = context.getBean(className);
            System.out.println("Ship " + className.getSimpleName() + " is here " + ship);
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("Ship " + className.getSimpleName() + " was destroyed or need to be repaired\n" + e.getMessage());
        }
    }
}
