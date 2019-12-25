package ru.akhitev.kb.spring.lookup_method_annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;

@Configuration
@ComponentScan(basePackageClasses = Launcher.class)
public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
        MachineGun problematicTLTurret = context.getBean(ProblematicTL50.class);
        System.out.println("try Problematic TL50 Repeater");
        useFiveBelts(problematicTLTurret);
        MachineGun correctTurboLaserTurret = context.getBean(CorrectTL50.class);
        System.out.println("try Correct  TL50 Repeater");
        useFiveBelts(correctTurboLaserTurret);
    }

    private static void useFiveBelts(MachineGun turret) {
        for (int i = 0; i < 5; i++) {
            turret.useAllCharges();
        }
    }
}
