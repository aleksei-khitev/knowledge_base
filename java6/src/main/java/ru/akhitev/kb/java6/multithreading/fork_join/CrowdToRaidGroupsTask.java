package ru.akhitev.kb.java6.multithreading.fork_join;

import java.util.concurrent.RecursiveTask;

import static ru.akhitev.kb.java6.multithreading.fork_join.RaidFormer.RAID_GROUP_MATE_LIMIT;

class CrowdToRaidGroupsTask extends RecursiveTask<Integer> implements GroupToRaidDivider {
    private final Integer crowd;

    CrowdToRaidGroupsTask(Integer crowd) {
        this.crowd = crowd;
    }

    @Override
    protected Integer compute() {
        if (underRaidGroupMateLimit(crowd)) {
            return 1;
        } else {
            Integer firstHalfOfMates = mateCountInFirstHalf(crowd);
            Integer secondHalfOfMates = mateCountInSecondHalf(crowd, firstHalfOfMates);
            CrowdToRaidGroupsTask firstPartTask = prepareTaskForHalfMates(firstHalfOfMates);
            CrowdToRaidGroupsTask secondPartTask = prepareTaskForHalfMates(secondHalfOfMates);

            // Запуск подзадач ветвления
            firstPartTask.fork();
            secondPartTask.fork();

            // Ожидание заверения и получение результата
            Integer firstPartGroupsNumber = firstPartTask.join();
            Integer secondPartGroupsNumber = secondPartTask.join();
            return firstPartGroupsNumber + secondPartGroupsNumber;
        }
    }

    private CrowdToRaidGroupsTask prepareTaskForHalfMates(Integer halfOfMates) {
        return new CrowdToRaidGroupsTask(halfOfMates);
    }
}
