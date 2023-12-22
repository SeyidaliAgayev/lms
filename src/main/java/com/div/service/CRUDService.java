package com.div.service;

import java.util.List;

public interface CRUDService<T> {
    T create();
    T getById(Long id);
    List<T> getAll();
    T update(Long id);
    void delete(Long id);
}
