package ru.akhitev.kb.java6.rtti.class_for_name;

public class ClassForNameNewInstance {

    /**
     * If class has default constructor, it can be created by newInstance method of the Class.
     * We can get Class object by using Class.forName
     * @param args
     */
    public static void main(String[] args) {
        try {
            Class<?> lostByReturnClass = Class.forName("ru.akhitev.kb.java6.rtti.class_for_name.ClassForNameNewInstance");
            ClassForNameNewInstance someClass = (ClassForNameNewInstance) lostByReturnClass.newInstance();
            someClass.printSomeThing();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    private void printSomeThing() {
        System.out.println("Something");
    }
}

// output:
// -------
// /opt/apps/java/jdk1.8.0_181/bin/java...
// Something
//
// Process finished with exit code 0