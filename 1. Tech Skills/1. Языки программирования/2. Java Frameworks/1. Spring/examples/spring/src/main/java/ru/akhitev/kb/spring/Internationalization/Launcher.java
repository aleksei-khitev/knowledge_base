package ru.akhitev.kb.spring.Internationalization;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

public class Launcher {
    private static Locale english = Locale.ENGLISH;
    private static Locale russian = new Locale("ru", "RU");

    public static void main(String[] args) {
        AbstractApplicationContext context = new GenericXmlApplicationContext("spring/Internationalization/beans.xml");

        System.out.println(context.getMessage("isd", null, english));
        System.out.println(context.getMessage("isd", null, russian));

        System.out.println(context.getMessage("arrived", new Object[]{"Devastator"}, english));
        System.out.println(context.getMessage("departure", new Object[]{"Devastator", "Tatooine"}, english));

        System.out.println(context.getMessage("arrived", new Object[]{"Опустошитель"}, russian));
        System.out.println(context.getMessage("departure", new Object[]{"Опустошитель", "Татуин"}, russian));

        context.close();
    }
}
