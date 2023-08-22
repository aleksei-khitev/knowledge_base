package ru.akhitev.kb.spring.lookup_method;

public class ProblematicTurboLaserTurret implements TurboLaserTurret {
    private TurboLaserShellBelt shellBelt;

    public void useAllCharges() {
        System.out.println(shellBelt + " was ended");
    }

    public void setShellBelt(TurboLaserShellBelt shellBelt) {
        this.shellBelt = shellBelt;
    }
}
