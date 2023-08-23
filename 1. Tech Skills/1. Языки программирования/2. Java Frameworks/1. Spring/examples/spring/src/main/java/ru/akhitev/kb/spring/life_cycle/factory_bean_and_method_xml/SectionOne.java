package ru.akhitev.kb.spring.life_cycle.factory_bean_and_method_xml;

import java.time.LocalDate;

public class SectionOne {
    public OperationAgent provideAgent() {
        if (LocalDate.now().getDayOfWeek().getValue() % 2 == 0) {
            return new Michael();
        } else {
            return new Nikita();
        }
    }

    private class Michael implements OperationAgent {
        @Override
        public String theOnlyReply() { return "I'm Michael. Where is he?"; }
    }

    private class Nikita implements OperationAgent {
        @Override
        public String theOnlyReply() { return "My name is Nikita. Tell me please, how to find him?"; }
    }
}
