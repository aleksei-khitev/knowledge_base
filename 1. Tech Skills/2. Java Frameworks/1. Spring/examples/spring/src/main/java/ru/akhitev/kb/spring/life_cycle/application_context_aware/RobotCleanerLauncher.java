package ru.akhitev.kb.spring.life_cycle.application_context_aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.time.LocalDate;

public class RobotCleanerLauncher implements ApplicationContextAware {
    private Rule rule;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (LocalDate.now().getDayOfWeek().getValue() > 5) {
            rule = applicationContext.getBean("weekEndRule", Rule.class);
        } else {
            rule = applicationContext.getBean("workingDayRule", Rule.class);
        }
    }

    public String whatSchedulerToday() {
        return rule.getName();
    }
}
