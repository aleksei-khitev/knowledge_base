package ru.akhitev.kb.spring.life_cycle.factory_bean_and_method_xml;

public class Operation {
    private OperationAgent agent;

    public Operation(OperationAgent agent) {
        this.agent = agent;
    }

    public OperationAgent getAgent() {
        return agent;
    }
}
