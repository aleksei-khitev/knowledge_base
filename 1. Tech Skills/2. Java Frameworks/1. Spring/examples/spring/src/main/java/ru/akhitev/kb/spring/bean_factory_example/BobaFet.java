package ru.akhitev.kb.spring.bean_factory_example;

class BobaFet implements BountyHunter {
    private static final String STATUS_TEMPLATE = "Hunting in progress.\n" +
            "%s will be delivered. Dead or alive";
    private String target;

    BobaFet(String target) { this.target = target; }

    @Override
    public String status() { return String.format(STATUS_TEMPLATE, target); }
}
