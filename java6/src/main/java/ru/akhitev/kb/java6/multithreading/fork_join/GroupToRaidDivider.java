package ru.akhitev.kb.java6.multithreading.fork_join;

import static ru.akhitev.kb.java6.multithreading.fork_join.RaidFormer.RAID_GROUP_MATE_LIMIT;

public interface GroupToRaidDivider {
    default Integer mateCountInFirstHalf(Integer crowd) { return crowd / 2; }

    default Integer mateCountInSecondHalf(Integer crowd, Integer forstPartMateCount) {
        return crowd - forstPartMateCount;
    }

    default boolean underRaidGroupMateLimit (Integer crowd) {
        return crowd <= RAID_GROUP_MATE_LIMIT;
    }
}
