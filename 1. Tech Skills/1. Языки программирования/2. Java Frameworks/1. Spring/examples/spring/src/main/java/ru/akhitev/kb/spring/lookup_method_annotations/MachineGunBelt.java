package ru.akhitev.kb.spring.lookup_method_annotations;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MachineGunBelt {
    private static final int DISCHARGES_COUNT = 100;
}
