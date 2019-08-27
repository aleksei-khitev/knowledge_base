package ru.akhitev.kb.java6.rtti.class_for_name;


public class GetClassForName {

    /**
     * We can see sich information like class name, classloader, constructors, fields and so on.
     * @param args
     */
    public static void main(String[] args) {
        try {
            String className = "ru.akhitev.kb.java6.exceptions.finally_lost_exception.LostByReturn";
            Class<?> lostByReturnClass = Class.forName(className);
            System.out.println("getName " + lostByReturnClass.getName());
            System.out.println("getSimpleName " + lostByReturnClass.getSimpleName());
            System.out.println("getCanonicalName " + lostByReturnClass.getCanonicalName());
            System.out.println("getTypeName " + lostByReturnClass.getTypeName());
            System.out.println("getClassLoader " + lostByReturnClass.getClassLoader());
            System.out.println("isInterface " + lostByReturnClass.isInterface());
            System.out.println("getInterfaces " + lostByReturnClass.getInterfaces());
            System.out.println("getSuperclass " + lostByReturnClass.getSuperclass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

// output:
// -------
// /opt/apps/java/jdk1.8.0_181/bin/java...
// getName ru.akhitev.kb.java6.exceptions.finally_lost_exception.LostByReturn
// getSimpleName LostByReturn
// getCanonicalName ru.akhitev.kb.java6.exceptions.finally_lost_exception.LostByReturn
// getTypeName ru.akhitev.kb.java6.exceptions.finally_lost_exception.LostByReturn
// getClassLoader sun.misc.Launcher$AppClassLoader@18b4aac2
// isInterface false
// getInterfaces [Ljava.lang.Class;@677327b6
// getSuperclass class java.lang.Object
//
// Process finished with exit code 0