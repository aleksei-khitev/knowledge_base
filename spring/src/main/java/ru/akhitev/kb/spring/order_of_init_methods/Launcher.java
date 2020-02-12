package ru.akhitev.kb.spring.order_of_init_methods;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class Launcher {

    @Lazy
    @Bean(initMethod = "init")
    public Captain captain() {
        return new Captain();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
        context.getBean(Captain.class);
    }
}
