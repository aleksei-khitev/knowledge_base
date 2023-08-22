package ru.akhitev.kb.spring.lookup_method;

public abstract class CorrectTurboLaserTurret implements TurboLaserTurret {
    public abstract TurboLaserShellBelt getNewShellBelt();

    public void useAllCharges() {
        System.out.println(getNewShellBelt() + " was ended");
    }
}
