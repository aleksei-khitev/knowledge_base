package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ByFill {
    public static void main(String[] args) {
        List<SomeSubClass> list = new ArrayList<>();
        list.add(new SomeSubClass());
        list.add(new SomeSubClass());
        list.add(new SomeSubClass());
        System.out.println(list);
        Collections.fill(list, new SomeSubClass());
        System.out.println(list);
    }

    private static class SomeSubClass {}
}
