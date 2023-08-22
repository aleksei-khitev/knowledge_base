package ru.akhitev.kb.spring.JSR_330;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Named("ship")
@Singleton
public class Ship {
    private Officer officer;

    @Inject
    @Named("officer")
    public Ship(Officer officer) {
        this.officer = officer;
    }

    public Officer getOfficer() {
        return officer;
    }
}
