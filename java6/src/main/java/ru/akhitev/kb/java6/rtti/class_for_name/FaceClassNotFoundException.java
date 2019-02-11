package ru.akhitev.kb.java6.rtti.class_for_name;

public class FaceClassNotFoundException {

    /**
     * ClassNotFoundException is exception when class not found.
     * Do not not to be confused with NoClassDefFoundError (when we had class on compile time and cannot load on runtime)!!!
     * @param args
     */
    public static void main(String[] args) {
        try {
            Class<?> lostByReturnClass = Class.forName("ru.akhitev.kb.java6.exceptions.finally_lost_exception.NonExistClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

// output:
// -------
// /opt/apps/java/jdk1.8.0_181/bin/java...
// java.lang.ClassNotFoundException: ru.akhitev.kb.java6.exceptions.finally_lost_exception.NonExistClass
//        at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
//        at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
//        at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:349)
//        at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
//        at java.lang.Class.forName0(Native Method)
//        at java.lang.Class.forName(Class.java:264)
//        at ru.akhitev.kb.java6.rtti.class_for_name.FaceClassNotFoundException.main(FaceClassNotFoundException.java:6)
//
//        Process finished with exit code 0