package ru.akhitev.kb.spring.order_of_init_methods;

import org.springframework.context.annotation.*;
import org.springframework.context.support.AbstractApplicationContext;

@Configuration
@ComponentScan
public class Launcher {

    @Lazy
    @Bean(initMethod = "init", destroyMethod = "deconstruct")
    public Captain captain() {
        return new Captain();
    }

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
        context.registerShutdownHook();
        context.getBean(Captain.class);
        System.out.println("=======");
    }
}
