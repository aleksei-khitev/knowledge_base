package ru.akhitev.kb.java6.annotations.apt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Для примера работы с apt,
 * эта аннотация будет использоваться для извлечения public методов
 * и генерации интерфейса.
 *
 * По этой причине, RetentionPolicy.SOURCE
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractInterface {
    public String value();
}
