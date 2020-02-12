package ru.akhitev.kb.spring.disposable_bean;

import org.springframework.beans.factory.DisposableBean;

public class Retro implements DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("Preparing new board");
        System.out.println("Copying new action points to Retro Chronicle page");
        System.out.println("Copying new action points to the new board as previous action points");
        System.out.println("Writing follow-up email with tickets, new action points and link to the new board");
    }
}
