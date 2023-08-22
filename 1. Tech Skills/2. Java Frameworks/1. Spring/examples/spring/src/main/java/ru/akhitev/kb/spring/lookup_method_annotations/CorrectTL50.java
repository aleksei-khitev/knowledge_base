package ru.akhitev.kb.spring.lookup_method_annotations;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class CorrectTL50 implements MachineGun {
    @Lookup
    public abstract MachineGunBelt getNewShellBelt();

    public void useAllCharges() {
        System.out.println(getNewShellBelt() + " was ended");
    }
}
