package ru.akhitev.kb.spring.lookup_method_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProblematicTL50 implements MachineGun {
    @Autowired
    private MachineGunBelt shellBelt;

    public void useAllCharges() {
        System.out.println(shellBelt + " was ended");
    }

    public void setShellBelt(MachineGunBelt shellBelt) {
        this.shellBelt = shellBelt;
    }
}
