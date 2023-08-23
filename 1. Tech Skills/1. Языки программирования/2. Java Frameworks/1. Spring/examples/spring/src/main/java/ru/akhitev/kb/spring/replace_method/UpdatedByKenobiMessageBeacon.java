package ru.akhitev.kb.spring.replace_method;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class UpdatedByKenobiMessageBeacon implements MethodReplacer {
    private static final String METHOD_NAME = "getMessage";

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        if (isNameSuits(method) && isArgumentsSuit(method) && isReturnTypeSuits(method)) {
            return "Ни в коем случае не возвращайтесь в храм! Прячьтесь!";
        } else {
            throw new IllegalArgumentException("Нельзя заменить метод " + method.getName());
        }
    }

    private boolean isNameSuits(Method method) {
        return METHOD_NAME.equals(method.getName());
    }

    private boolean isArgumentsSuit(Method method) {
        return method.getParameterCount() == 0;
    }

    private boolean isReturnTypeSuits(Method method) {
        return method.getReturnType() == String.class;
    }
}
