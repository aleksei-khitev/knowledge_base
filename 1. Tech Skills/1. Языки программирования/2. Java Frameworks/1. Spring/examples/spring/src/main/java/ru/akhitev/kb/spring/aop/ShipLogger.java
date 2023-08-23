package ru.akhitev.kb.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ShipLogger implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("[ShipLog] Initiating jump through hyper space.");
        System.out.print("[ShipLog] Target: ");
        System.out.println(invocation.getMethod().getParameters()[0]);
        return invocation.proceed();
    }
}
