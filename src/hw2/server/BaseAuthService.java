package hw2.server;

import java.util.ArrayList;
import java.util.List;

public class BaseAuthService implements AuthService {
    private DBManager dbManager;

    @Override
    public void start() {
        dbManager = new DBManager();
        System.out.println("Сервис авторизации запущен");
    }

    @Override
    public void stop() {
        System.out.println("Сервис авторизации остановлен");
    }

    @Override
    public String getNickByLoginAndPass(String login, String password) {
        return dbManager.getNickByLoginAndPass(login, password);
    }
}
