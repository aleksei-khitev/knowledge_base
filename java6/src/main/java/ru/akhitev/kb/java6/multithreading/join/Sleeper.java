package ru.akhitev.kb.java6.multithreading.join;

public class Sleeper extends Thread {
    @Override
    public void run() {
        try {
            System.out.println(getId() + "(Sleeper) начал работу");
            sleep(2000);
            System.out.println(getId() + "(Sleeper) окончил работу");
        } catch (InterruptedException e) {
            System.out.println(getId() + "(Sleeper) был прерван");
        }
    }
}
