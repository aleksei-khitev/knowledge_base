package ru.akhitev.kb.java6.annotations;

public class SomeClass {

    @Refactor
    public void someMethod() {
        System.out.println("something");
    }

    @ToDo(description = "Закончить")
    public void anotherMethod() {
        int a = 1;
    }
}
