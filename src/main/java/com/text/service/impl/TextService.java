package com.text.service.impl;

import com.text.entities.Text;
import com.text.exception.DaoException;
import com.text.exception.ServiceException;
import com.text.model.Repository;
import com.text.model.impl.TextModel;
import com.text.service.Service;

public class TextService implements Service<Text> {
private final Repository<Text> repository = new TextModel();
    @Override
    public void create(Text entity) throws ServiceException {
        try {
            repository.insert(entity);
        } catch (DaoException e) {
            throw new ServiceException("text cant add");

        }
    }

    @Override
    public Text read(int id) throws ServiceException {
        try {
           return repository.select(id);
        } catch (DaoException e) {
            throw new ServiceException("text cant add");
        }
    }
}
