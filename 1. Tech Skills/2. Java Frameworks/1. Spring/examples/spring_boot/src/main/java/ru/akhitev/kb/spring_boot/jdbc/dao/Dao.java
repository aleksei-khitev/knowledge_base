package ru.akhitev.kb.spring_boot.jdbc.dao;

import java.util.List;

public interface Dao<T> {
    List<T> findAll();
}
