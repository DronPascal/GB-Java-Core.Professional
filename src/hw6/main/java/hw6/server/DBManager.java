package hw6.server;

import java.sql.*;

public class DBManager {
    private Connection connection = null;
    private Statement statement;

    public DBManager() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:src/hw6/main/resources/sqlite_db.s3db");
            if (connection != null) {
                LogManager.LOG.trace("Соединение c БД установлено");
                statement = connection.createStatement();
                addRecords();
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            LogManager.LOG.trace("Ошибка подключения к БД!");
        }
    }

    private void addRecords() {
        try {
//            statement.executeUpdate("insert into 'users' (login, password, nickname) values (\"andrew\",\"password\",\"Dron\")");
//            statement.executeUpdate("insert into 'users' (login, password, nickname) values (\"alice\",\"12345678\",\"Niffin\")");
//            statement.executeUpdate("insert into 'users' (login, password, nickname) values (\"igor\",\"1111\",\"Crazy\")");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public String getNickByLoginAndPass(String login, String password) {
        String nick;
        try {
            ResultSet resultSet = statement.executeQuery("select nickname from users where login=\"" + login + "\" and password=\"" + password + "\"");
            nick = resultSet.getString(1);
            //System.out.println(nick);
            return nick;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    public void changeNick(String oldNick, String newNick) {
        try {
            statement.executeUpdate("update 'users' set nickname=\""+newNick+"\" where nickname=\""+oldNick+"\"");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
