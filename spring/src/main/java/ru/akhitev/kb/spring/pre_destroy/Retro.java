package ru.akhitev.kb.spring.pre_destroy;

import javax.annotation.PreDestroy;

public class Retro {

    @PreDestroy
    public void destruct() throws Exception {
        System.out.println("Preparing new board");
        System.out.println("Copying new action points to Retro Chronicle page");
        System.out.println("Copying new action points to the new board as previous action points");
        System.out.println("Writing follow-up email with tickets, new action points and link to the new board");
    }
}
