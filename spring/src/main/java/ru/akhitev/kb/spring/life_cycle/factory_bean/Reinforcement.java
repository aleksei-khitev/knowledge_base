package ru.akhitev.kb.spring.life_cycle.factory_bean;

import ru.akhitev.kb.spring.life_cycle.factory_bean.ship.ISD;

public class Reinforcement {
    private ISD isd;

    public Reinforcement(ISD isd) {
        this.isd = isd;
    }

    public ISD getIsd() {
        return isd;
    }
}
