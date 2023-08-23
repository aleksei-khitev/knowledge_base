package ru.akhitev.kb.spring.c_namespace;

public class MessageBeam {
    private final String message;

    public MessageBeam(String message) { this.message = message; }

    public void repeatMessage() {
        for (int i = 0; i < 10; i++) { System.out.println(message); }
    }
}
