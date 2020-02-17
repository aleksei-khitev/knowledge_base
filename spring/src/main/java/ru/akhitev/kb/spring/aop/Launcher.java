package ru.akhitev.kb.spring.aop;

import org.springframework.aop.framework.ProxyFactory;

public class Launcher {
    public static void main(String[] args) {
        Ship ship = new Ship();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new ShipLogger());
        proxyFactory.setTarget(ship);

        Ship proxyShip = (Ship) proxyFactory.getProxy();
        proxyShip.jump("Beta Durany");
    }
}
