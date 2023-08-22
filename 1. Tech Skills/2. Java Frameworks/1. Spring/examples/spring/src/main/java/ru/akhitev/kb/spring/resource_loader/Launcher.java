package ru.akhitev.kb.spring.resource_loader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

@Configuration
public class Launcher {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);

        File file = File.createTempFile("test", "txt");
        file.deleteOnExit();

        Resource fileResource = context.getResource("file://" + file.getPath());
        displayInfo(fileResource);

        Resource urlResource = context.getResource("http://www.google.com");
        displayInfo(urlResource);
    }

    private static void displayInfo(Resource resource) throws IOException {
        System.out.println(resource.getClass());
        System.out.println(resource.getURL().getContent());
        System.out.println(resource.getURI());
        System.out.println("---");
    }
}
