package ru.akhitev.kb.spring.aliases;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("spring/aliases/beans.xml");
        System.out.println(Arrays.toString(context.getAliases("ISD")));
        System.out.println(Arrays.toString(context.getAliases("Imperial_I")));
        System.out.println(Arrays.toString(context.getAliases("VictorySD")));
    }
}
