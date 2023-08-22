package ru.akhitev.kb.spring.parent_context.ships;

import ru.akhitev.kb.spring.parent_context.yard.ShipYard;

public class ImperialStartDestroyer implements MilitaryShip {
    private final ShipYard yard;

    public ImperialStartDestroyer(ShipYard yard) {
        this.yard = yard;
    }

    @Override
    public String toString() {
        return "ImperialStartDestroyer{" +
                "yard=" + yard +
                '}';
    }
}
