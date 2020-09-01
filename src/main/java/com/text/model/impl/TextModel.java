package com.text.model.impl;

import com.text.entities.Text;
import com.text.exception.DaoException;
import com.text.model.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TextModel implements Repository<Text> {
private static final String INSERT = "insert into text (numberLine ) values (?)";
private static final String SELECT = "select * form text where id=(?)";
    @Override
    public void insert(Text entity) throws DaoException {
        try {
            PreparedStatement statement =connection.prepareStatement(INSERT);
            statement.setInt(1,entity.getNumberLine());
            statement.executeUpdate();
        } catch (SQLException e) {
           throw new DaoException("text cant insert");
        }

    }

    @Override
    public Text select(int id) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                int textId = resultSet.getInt(1);
                int numberLine = resultSet.getInt("number_line");
                Text text = new Text();
                text.setId(textId);
                text.setNumberLine(numberLine);
                return text;
            }
        } catch (SQLException throwables) {
            throw new DaoException("text cant select");
        }
        return null;
    }
}
