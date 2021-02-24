package hw6.server;

public class BaseAuthService implements AuthService {
    private DBManager dbManager;

    public BaseAuthService(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public void start() {
        LogManager.LOG.trace("Сервис авторизации запущен");
    }

    @Override
    public void stop() {
        LogManager.LOG.trace("Сервис авторизации остановлен");
    }

    @Override
    public String getNickByLoginAndPass(String login, String password) {
        return dbManager.getNickByLoginAndPass(login, password);
    }
}
