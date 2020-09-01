package com.text.service;

import com.text.exception.ServiceException;

public interface Service<T> {
        public void create(T entity) throws ServiceException;
        public T read(int id) throws ServiceException;
}
