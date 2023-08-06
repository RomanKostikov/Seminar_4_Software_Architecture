package Services;

import Interfaces.IUserRepo;
import Models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс репозиторий для имитации работы с базой данных
 */
public class UserRepository implements IUserRepo {
    private static UserRepository clientRepository;
    private List<User> clients;

    private UserRepository() {
        //имитация работы базы клиентов
        clients = new ArrayList<>();
        clients.add(new User(1, "Ivan", "1111".hashCode(), 2));
        clients.add(new User(2, "Vasiliy", "2222".hashCode(), 3));
        clients.add(new User(3, "Fedor", "3333".hashCode(), 4));
        clients.add(new User(4, "Grigoriy", "4444".hashCode(), 5));
    }

    public static UserRepository getClientRepository() {
        if (clientRepository == null) {
            clientRepository = new UserRepository();
        }
        return clientRepository;
    }

    @Override
    public int create(String userName, int passwordHash, long cardNumber) throws RuntimeException {
        int id = clients.size() + 1;
        User client = new User(id, userName, passwordHash, cardNumber);
        for (var currentClient : clients) {
            if (currentClient.getId() == client.getId()) {
                throw new RuntimeException("A client already exists");
            }
        }
        clients.add(client);
        return client.getId();
    }

    @Override
    public User read(int id) throws RuntimeException {
        for (var client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        throw new RuntimeException("A client with this ID not found");
    }

    @Override
    public User read(String userName) throws RuntimeException {
        for (var client : clients) {
            var clientName = client.getUserName();
            if (clientName.equals(userName)) {
                return client;
            }
        }
        throw new RuntimeException("A client with this ID not found");
    }

    @Override
    public List<User> readAll() throws RuntimeException {
        if (clients.isEmpty()) {
            throw new RuntimeException("List of clients is empty");
        }
        return clients;
    }

    @Override
    public boolean update(User client) {
        User tempClient = null;
        for (User currentClient : clients) {
            if (currentClient.getId() == client.getId()) {
                clients.remove(currentClient);
                clients.add(client);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(User client) {
        for (User currentClient : clients) {
            if (currentClient.equals(client)) {
                clients.remove(currentClient);
                return true;
            }
        }
        return false;
    }
}
