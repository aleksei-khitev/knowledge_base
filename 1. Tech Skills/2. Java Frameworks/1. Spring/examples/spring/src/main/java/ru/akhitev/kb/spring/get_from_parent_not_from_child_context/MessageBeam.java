package ru.akhitev.kb.spring.get_from_parent_not_from_child_context;

public class MessageBeam {
    private final String message;

    public MessageBeam(String message) {
        this.message = message;
    }

    public void repeatMessage() {
        for (int i = 0; i < 10; i++) {
            System.out.println(message);
        }
    }
}
