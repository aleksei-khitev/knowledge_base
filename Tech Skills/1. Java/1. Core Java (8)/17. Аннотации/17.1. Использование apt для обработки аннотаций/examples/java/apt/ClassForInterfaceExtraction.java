package apt;

/**
 * Хотим, чтобы имя интерфейса было ExtractedInterface
 */
@ExtractInterface("ExtractedInterface")
public class ClassForInterfaceExtraction {
    public void somePublicMethod() {
        System.out.println("some public method invokation");
    }

    public void anotherPublicMethod() {
        System.out.println("another public method invokation");
    }

    private void somePrivateMethod() {
        System.out.println("some private method invokation");
    }
}
