package optional;

import java.util.Optional;

public class TeamObserver {
    public static void main(String[] args) {
        flatMapExample(prepareNullTeam());
        flatMapExample(prepareTeamWithDeveloperAndQaAndMayBeBa(null));
    }

    private static void mapExample(Optional<Team> team) {
        System.out.println("--- mapExample ---");
        System.out.println(team.map(Team::getDeveloper));
        System.out.println(team.map(Team::getBusinessAnalyst));
        System.out.println(team.map(Team::getQaEngineer));
    }

    private static void mapFailureExample(Optional<Team> team) {
        System.out.println("--- mapFailureExample ---");
        //System.out.println(team.map(Team::getQaEngineer).map(QaEngineer::isAutomationQa));
    }

    private static void flatMapExample(Optional<Team> team) {
        System.out.println("--- flatMapExample ---");
        System.out.println(team.flatMap(Team::getQaEngineer).map(QaEngineer::isAutomationQa));
    }

    private static Optional<Team> prepareNullTeam() {
        return Optional.empty();
    }

    private static Optional<Team> prepareTeamWithDeveloperOnly() {
        return Optional.of(new Team(new Developer(), Optional.empty(), Optional.empty()));
    }

    private static Optional<Team> prepareTeamWithDeveloperAndBa() {
        return Optional.of(new Team(new Developer(), Optional.of(new BusinessAnalyst()), Optional.empty()));
    }

    private static Optional<Team> prepareTeamWithDeveloperAndQaAndMayBeBa(BusinessAnalyst ba) {
        return Optional.of(new Team(new Developer(), Optional.ofNullable(ba), Optional.of(new QaEngineer())));
    }
}
