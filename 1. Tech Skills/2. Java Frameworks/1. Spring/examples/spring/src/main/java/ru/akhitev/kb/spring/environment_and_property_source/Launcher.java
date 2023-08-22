package ru.akhitev.kb.spring.environment_and_property_source;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class Launcher {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
        ConfigurableEnvironment environment = context.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        //addSomePropertyLast(propertySources);
        addSomePropertyFirst(propertySources);

        System.out.println("System.getProperty user.home = " + System.getProperty("user.home"));
        System.out.println("System.getenv PATH = " + System.getenv("PATH"));
        System.out.println("environment.getProperty user.home = " + environment.getProperty("user.home"));
        System.out.println("environment.getProperty PATH = " + environment.getProperty("PATH"));

        context.close();

        System.out.println("environment.getProperty user.home = " + environment.getProperty("user.home"));
    }

    private static void addSomePropertyLast(MutablePropertySources propertySources) {
        Map<String, Object> appMap = new HashMap<>();
        appMap.put("user.home", "application_home");
        propertySources.addLast(new MapPropertySource("knowledgeBase_MAP", appMap));
    }

    private static void addSomePropertyFirst(MutablePropertySources propertySources) {
        Map<String, Object> appMap = new HashMap<>();
        appMap.put("user.home", "application_home");
        propertySources.addFirst(new MapPropertySource("knowledgeBase_MAP", appMap));
    }
}
