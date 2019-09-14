package ru.akhitev.kb.java6.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class SimpleAnnotationProcessor {
    public static void main(String[] args) {
        Class<SomeClass> clazz = SomeClass.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            for (Annotation annotation : declaredAnnotations) {
                StringBuilder message = new StringBuilder();
                message.append(clazz.getSimpleName()).append(" ").append(method.getName()).append(" ");
                if (annotation instanceof Refactor) {
                    message.append("should be refactored");
                } else if (annotation instanceof ToDo) {
                    ToDo toDo = (ToDo) annotation;
                    message.append(" has a ToDo with message: [");
                    message.append(toDo.description()).append("] ");
                    message.append("For mo information please ask [").append(toDo.author()).append("]");
                }
                System.out.println(message.toString());
            }
        }
    }
}
