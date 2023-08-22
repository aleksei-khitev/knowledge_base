package ru.akhitev.kb.spring.life_cycle.factory_bean;

import org.springframework.beans.factory.FactoryBean;
import ru.akhitev.kb.spring.life_cycle.factory_bean.ship.ISD;
import ru.akhitev.kb.spring.life_cycle.factory_bean.supplier.EngineFactory;
import ru.akhitev.kb.spring.life_cycle.factory_bean.supplier.SeinarFactory;
import ru.akhitev.kb.spring.life_cycle.factory_bean.supplier.WeaponFactory;

public class KuatShipYard implements FactoryBean<ISD> {
    private EngineFactory engineFactory;
    private WeaponFactory weaponFactory;
    private SeinarFactory seinarFactory;

    public KuatShipYard(EngineFactory engineFactory, WeaponFactory weaponFactory, SeinarFactory seinarFactory) {
        this.engineFactory = engineFactory;
        this.weaponFactory = weaponFactory;
        this.seinarFactory = seinarFactory;
    }

    @Override
    public ISD getObject() throws Exception {
        System.out.println("Request drive, hyper drive, torpedos, turbolasers, ties");
        engineFactory.requestDrive();
        engineFactory.requestHyperDrive();
        weaponFactory.requestTorpedo();
        weaponFactory.requestTurboLasers();
        seinarFactory.requestTies();
        System.out.println("Construct and send ISD");
        return new ISD();
    }

    @Override
    public Class<?> getObjectType() {
        return ISD.class;
    }
}
