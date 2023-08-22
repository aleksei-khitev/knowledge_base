package threads.fork_join;

import java.util.concurrent.ForkJoinPool;

class RaidFormer {
    private static final Integer crowdMateNumber = 23;
    static final int RAID_GROUP_MATE_LIMIT = 6;

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println("Решили собрать пикапный рейд из " + crowdMateNumber);
        System.out.println("Максимальное число людей в группе "
                + RAID_GROUP_MATE_LIMIT);
        Integer raidGroupCount = pool.invoke(new CrowdToRaidGroupsTask(crowdMateNumber));
        System.out.println("Получился рейд из " + raidGroupCount + " груп");
        pool.invoke(new CrowdToRaidGroupsAction(crowdMateNumber));
    }
}
