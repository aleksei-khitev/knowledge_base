package ru.akhitev.kb.spring.jpa.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.akhitev.kb.spring.jpa.entity.FleetUnit;

import java.util.List;

public interface FleetUnitRepo extends CrudRepository<FleetUnit, Long> {
    List<FleetUnit> findByName(String name);

    @Query("select fu " +
            "from FleetUnit fu " +
            "where fu.name like %:name% " +
            "and fu.commandRank.name like %:commandRankName%")
    List<FleetUnit> findByNameAndCommandRankName(@Param("name") String name,
                                                        @Param("commandRankName") String commandRankName);
}
