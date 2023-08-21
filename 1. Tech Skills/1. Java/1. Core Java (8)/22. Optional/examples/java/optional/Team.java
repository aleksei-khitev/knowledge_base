package optional;

import java.util.Optional;

class Team {
    private Developer developer;
    private Optional<BusinessAnalyst> businessAnalyst;
    private Optional<QaEngineer> qaEngineer;

    Team(Developer developer, Optional<BusinessAnalyst> businessAnalyst, Optional<QaEngineer> qaEngineer) {
        this.developer = developer;
        this.businessAnalyst = businessAnalyst;
        this.qaEngineer = qaEngineer;
    }

    Developer getDeveloper() { return developer; }

    Optional<BusinessAnalyst> getBusinessAnalyst() { return businessAnalyst; }

    Optional<QaEngineer> getQaEngineer() { return qaEngineer; }
}
