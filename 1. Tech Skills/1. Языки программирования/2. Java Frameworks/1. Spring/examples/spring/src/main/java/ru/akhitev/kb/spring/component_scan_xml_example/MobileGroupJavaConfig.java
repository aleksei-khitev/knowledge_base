package ru.akhitev.kb.spring.component_scan_xml_example;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.akhitev.kb.spring.component_scan_xml_example.ships.Agamemnon;
import ru.akhitev.kb.spring.component_scan_xml_example.ships.MilitaryShip;
import ru.akhitev.kb.spring.component_scan_xml_example.ships.Rage;
import ru.akhitev.kb.spring.component_scan_xml_example.ships.Victory;

@Configuration
@ComponentScan(basePackageClasses = ru.akhitev.kb.spring.component_scan_xml_example.ships.MilitaryShip.class,
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Victory.class) })
public class MobileGroupJavaConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MobileGroupJavaConfig.class);
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
