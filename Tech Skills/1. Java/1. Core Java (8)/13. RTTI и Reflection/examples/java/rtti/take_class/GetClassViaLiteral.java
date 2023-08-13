package rtti.take_class;

public class GetClassViaLiteral {

    /**
     * It is better, because of check on compile time!
     *
     * Making Class via .class doesn't initialize Class object. classForName(...) does.
     * @param args
     */
    public static void main(String[] args) {
        Class<GetClassViaLiteral> getClassViaLiteralClass = GetClassViaLiteral.class;
    }
}
