package ru.akhitev.kb.spring.value_annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageBeam {
    private final String message;

    public MessageBeam(@Value("#{message}") String message) {
        this.message = message;
    }

    public void repeat() {
        for (int i = 0; i < 10; i++) {
            System.out.println(message);
        }
    }
}
