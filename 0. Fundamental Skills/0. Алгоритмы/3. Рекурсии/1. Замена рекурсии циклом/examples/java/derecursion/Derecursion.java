package derecursion;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Путем добавления элементов в очередь на обработку, можно вместо рекурсии использовать обычный цикл
 */
public class Derecursion {
    public boolean hasKey(Box box) {
        Queue<Box> boxes = new LinkedList<>();
        boxes.offer(box);
        while(!boxes.isEmpty()) {
            Box currentBox = boxes.poll();
            if (currentBox.isContainsKey()) {
                return true;
            }
            if (currentBox.hasSubBoxes()) {
                for (Box subBox : currentBox.getSubBoxes()) {
                    boxes.offer(subBox);
                }
            }
        }
        return false;
    }
}
