package ru.akhitev.kb.spring.get_from_parent_not_from_child_context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext parent = new GenericXmlApplicationContext("spring/get_from_parent_not_from_child_context/parent.xml");
        GenericXmlApplicationContext child = new GenericXmlApplicationContext();
        child.load("spring/get_from_parent_not_from_child_context/child.xml");
        child.setParent(parent);
        child.refresh();
        MessageBeam beam = child.getBean("Beam", MessageBeam.class);
        beam.repeatMessage();
    }
}
