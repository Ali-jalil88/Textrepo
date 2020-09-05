package com.text.service.impl;

import com.text.entities.Text;
import com.text.exception.DaoException;
import com.text.exception.ServiceException;
import com.text.model.Repository;
import com.text.model.impl.TextModel;
import com.text.service.Service;


public class TextService implements Service<Text> {
    private TextModel repository = new TextModel();
    @Override
    public void create(Text entity) throws ServiceException {
        try {
            repository.insert(entity);
        } catch (DaoException e) {
            throw new ServiceException("text cant add");

        }
    }

    @Override
    public Text read(int id) throws ServiceException, ServiceException {
        try {
            System.out.println("in dao");
            System.out.println(id);
            return repository.selectById(id);
        } catch (DaoException e) {
            throw new ServiceException("cant get text using id");
        }
    }
    public Text reading() throws ServiceException, ServiceException {
        Text text = new Text();
        try {
            text = repository.selectAll();
        } catch (DaoException e) {
            throw new ServiceException("getting text back from DAO");
        }
        return text;
    }
}
