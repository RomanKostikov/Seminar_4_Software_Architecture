package Core;

import Interfaces.IUserRepo;
import Models.User;
import Services.UserRepository;

import java.util.List;

/**
 * Класс - провайдер для работы с базой данных клиентов
 */
public class UserProvider {
    private IUserRepo clientRepository;

    /**
     * Конструктор класса
     */
    public UserProvider() {
        // Класс репозитория находится в единственном экземпляре для того, чтобы не создавать несколько подключений
        // к базе данных. Реализация паттерна Синглтон.
        this.clientRepository = UserRepository.getClientRepository();
    }

    /**
     * Метод создания нового клиента
     *
     * @param userName     имя клиента
     * @param passwordHash хэш пароля
     * @param cardNumber   номер банковской карты
     * @return ID клиента в базе
     * @throws RuntimeException
     */
    public int createClient(String userName, int passwordHash, long cardNumber) throws RuntimeException {
        int id = clientRepository.create(userName, passwordHash, cardNumber);
        return id;
    }

    /**
     * Метод поиска клиента из базы по имени
     *
     * @param userName имя клиента
     * @return модель клиента
     * @throws RuntimeException
     */
    public User getClientByName(String userName) throws RuntimeException {
        var client = clientRepository.read(userName);
        return client;
    }

    /**
     * Метод получения списка всех клиентов (для реализации тестов и администрирования), не используется.
     *
     * @return список клиентов
     * @throws RuntimeException
     */
    public List<User> getAllClients() throws RuntimeException {
        var clients = clientRepository.readAll();
        return clients;
    }
}
