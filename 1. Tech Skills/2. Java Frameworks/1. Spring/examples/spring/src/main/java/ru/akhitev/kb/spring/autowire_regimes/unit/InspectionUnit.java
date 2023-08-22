package ru.akhitev.kb.spring.autowire_regimes.unit;

import ru.akhitev.kb.spring.autowire_regimes.fighter.TieBomber;
import ru.akhitev.kb.spring.autowire_regimes.fighter.TieFighter;
import ru.akhitev.kb.spring.autowire_regimes.fighter.TieInterceptor;

public class InspectionUnit {
    private TieFighter tieFighter;
    private TieInterceptor tieInterceptor;
    private TieBomber tieBomber;

    public InspectionUnit() {
    }

    public InspectionUnit(TieFighter tieFighter) {
        System.out.println("Constructor with 1 argument");
        this.tieFighter = tieFighter;
    }

    public InspectionUnit(TieFighter tieFighter, TieInterceptor tieInterceptor) {
        System.out.println("Constructor with 2 arguments");
        this.tieFighter = tieFighter;
        this.tieInterceptor = tieInterceptor;
    }

    public InspectionUnit(TieFighter tieFighter, TieInterceptor tieInterceptor, TieBomber tieBomber) {
        System.out.println("Constructor with 3 arguments");
        this.tieFighter = tieFighter;
        this.tieInterceptor = tieInterceptor;
        this.tieBomber = tieBomber;
    }

    public void setTieFighter(TieFighter tieFighter) {
        System.out.println("set Tie Fighter");
        this.tieFighter = tieFighter;
    }

    public void setTieInterceptor(TieInterceptor tieInterceptor) {
        System.out.println("set Tie Interceptor");
        this.tieInterceptor = tieInterceptor;
    }

    public void setTieBomber(TieBomber tieBomber) {
        System.out.println("set Tie Bomber");
        this.tieBomber = tieBomber;
    }
}
