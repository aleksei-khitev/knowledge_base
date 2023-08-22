package ru.akhitev.kb.spring.JSR_330;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Launcher.class)
public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
        System.out.println(context.getBean(Officer.class));
        System.out.println(context.getBean(Officer.class));
        System.out.println(context.getBean(Officer.class));
        System.out.println(context.getBean(Officer.class));
        System.out.println(context.getBean(Ship.class).getOfficer());
        System.out.println(context.getBean(Ship.class));
        System.out.println(context.getBean(Ship.class));
    }
}
