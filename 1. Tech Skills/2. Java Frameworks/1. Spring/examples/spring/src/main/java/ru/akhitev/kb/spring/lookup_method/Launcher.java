package ru.akhitev.kb.spring.lookup_method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("spring/lookup_method/beans.xml");
        TurboLaserTurret problematicTLTurret = context.getBean(ProblematicTurboLaserTurret.class);
        System.out.println("try ProblematicTurret");
        useFiveBelts(problematicTLTurret);
        TurboLaserTurret correctTurboLaserTurret = context.getBean(CorrectTurboLaserTurret.class);
        System.out.println("try CorrectTurret");
        useFiveBelts(correctTurboLaserTurret);
    }

    private static void useFiveBelts(TurboLaserTurret turret) {
        for (int i = 0; i < 5; i++) {
            turret.useAllCharges();
        }
    }
}
