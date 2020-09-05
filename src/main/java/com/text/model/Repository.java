package com.text.model;

import com.text.exception.DaoException;
import java.sql.Connection;

public interface Repository<T> {
    Connection connection = ConnectionBuilder.getConnection();
     void insert (T entity) throws DaoException;
    T select(int id) throws DaoException;
}
