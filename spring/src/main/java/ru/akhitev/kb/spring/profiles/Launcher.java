package ru.akhitev.kb.spring.profiles;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.akhitev.kb.spring.profiles.java_configs.ArcheAge;
import ru.akhitev.kb.spring.profiles.java_configs.Lotro;
import ru.akhitev.kb.spring.profiles.java_configs.Vko;

public class Launcher {
    public static void main(String[] args) {
        //withVmArgumentSet(); //не забыть про VM option!!
        //environmentSetActiveProfile();
        environmentAndJavaConfig();
    }

    // Добавить -Dspring.profiles.active="ВКО" в VM optons
    private static void withVmArgumentSet() {
        ApplicationContext context = new GenericXmlApplicationContext("spring/profiles/*.xml");
        System.out.println(context.getBean(BrothersMmoPair.class));
    }

    private static void environmentSetActiveProfile() {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.getEnvironment().setActiveProfiles("lotro");
        context.load("spring/profiles/*.xml");
        context.refresh();
        System.out.println(context.getBean(BrothersMmoPair.class));
    }

    private static void environmentAndJavaConfig() {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(Lotro.class, Vko.class, ArcheAge.class);
        System.out.println(context.getBean(BrothersMmoPair.class));
    }
}
