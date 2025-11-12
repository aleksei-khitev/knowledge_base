package derecursion;

import java.util.ArrayList;
import java.util.Collection;

public class Box {
    private final boolean containsKey;
    private Collection<Box> subBoxes;

    public Box(boolean containsKey, Box... boxes) {
        this.containsKey = containsKey;
        if (boxes != null) {
            subBoxes = new ArrayList<>();
        }
        for (Box subBox : boxes) {
            subBoxes.add(subBox);
        }
    }

    public boolean isContainsKey() {
        return containsKey;
    }

    public boolean hasSubBoxes() {
        return subBoxes != null;
    }

    public Collection<Box> getSubBoxes() {
        return subBoxes;
    }
}
