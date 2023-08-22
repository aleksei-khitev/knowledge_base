package ru.akhitev.kb.spring.environment_properties_injection_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericXmlApplicationContext;

@Configuration
@ComponentScan(basePackageClasses = Launcher.class)
@PropertySources({
        @PropertySource("classpath:spring/environment_properties_injection/infrastructure.properties"),
        @PropertySource("classpath:spring/environment_properties_injection/user.properties")
})
public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
        System.out.println(context.getBean(HomeInfrastructureInfo.class));
        System.out.println(context.getBean(UserInfo.class).getHomeDir());
        System.out.println(context.getEnvironment().getProperty("transmission.address"));
    }
}
