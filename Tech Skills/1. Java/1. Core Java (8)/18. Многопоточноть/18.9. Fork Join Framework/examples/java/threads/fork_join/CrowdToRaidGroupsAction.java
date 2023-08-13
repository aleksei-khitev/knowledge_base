package threads.fork_join;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

class CrowdToRaidGroupsAction extends RecursiveAction implements GroupToRaidDivider {
    private final Integer crowd;

    CrowdToRaidGroupsAction(Integer crowd) { this.crowd = crowd; }

    @Override
    protected void compute() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (underRaidGroupMateLimit(crowd)) {
            System.out.println("В группе " + crowd + " человек");
        } else {
            Integer firstHalfOfMates = mateCountInFirstHalf(crowd);
            Integer secondHalfOfMates = mateCountInSecondHalf(crowd, firstHalfOfMates);
            CrowdToRaidGroupsAction firstPartTask = prepareActionForHalfMates(firstHalfOfMates);
            CrowdToRaidGroupsAction secondPartTask = prepareActionForHalfMates(secondHalfOfMates);
            invokeAll(firstPartTask, secondPartTask);
        }
    }

    private CrowdToRaidGroupsAction prepareActionForHalfMates(Integer halfOfMates) {
        return new CrowdToRaidGroupsAction(halfOfMates);
    }
}
