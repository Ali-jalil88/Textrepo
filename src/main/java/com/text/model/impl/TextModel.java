package com.text.model.impl;
import com.text.entities.Text;
import com.text.exception.DaoException;
import com.text.model.Repository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TextModel implements Repository<Text> {
private static final String INSERT = "insert into textTable (text) values (?)";
private static final String SELECT = "select * form textTable where id=(?)";
    @Override
    public void insert(Text entity) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(1, entity.getFullText());
            statement.executeUpdate();
        } catch (SQLException e) {
           throw new DaoException("text cant insert ");
        }
    }
    public Text selectAll() throws DaoException {
        Text text = new Text();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from text order by id desc limit 1")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                text.setFullText(resultSet.getString("txt"));
                text.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            throw new DaoException("getting text back from db");
        }
        return text;
    }
    @Override
    public Text select(int id) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                int textId = resultSet.getInt(1);
                Text text = new Text();
                text.setId(textId);
                return text;
            }
        } catch (SQLException throwables) {
            throw new DaoException("text cant select");
        }
        return null;
    }
    public Text selectById(int id) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from textTable  WHERE id = (?)")) {
            System.out.println("in actual dao" + id);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Text text = new Text();
                text.setFullText(resultSet.getString("text"));
                text.setId(resultSet.getInt("id"));
                System.out.println("printing text in dao " + text.getFullText());
                System.out.println("printing text ... in dao " + text.getFullText().toString());
                System.out.println(text.getId());
                return text;
            }
        } catch (SQLException e) {
            System.out.println(e);

            throw new DaoException("");
        }
        return null;
    }

}
