package Services;

import Interfaces.ICashRepo;
import Models.BankAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс репозиторий для имитации работы с базой данных банка
 */
public class CashRepository implements ICashRepo {
    private static CashRepository cashRepository;

    private List<BankAccount> clients;

    public List<BankAccount> getClients() {
        return clients;
    }

    private CashRepository() {
        //имитация работы банка
        clients = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            clients.add(new BankAccount());
        }

    }

    public static CashRepository getCashRepository() {
        if (cashRepository == null) {
            cashRepository = new CashRepository();
        }
        return cashRepository;
    }

    @Override
    public boolean transaction(int payment, long cardFrom, long carrierСard) throws RuntimeException {
        // Проводим валидацию аккаунтов
        BankAccount from = null;
        BankAccount to = null;
        for (var client : clients) {
            if (client.getCard() == cardFrom) {
                from = client;
            }
            if (client.getCard() == carrierСard) {
                to = client;
            }
        }
        // Проверяем наличие банковских карт продавца и покупателя
        if (from == null) {
            throw new RuntimeException("No withdrawal account.");
        }
        if (to == null) {
            throw new RuntimeException("No money account.");
        }
        // Проверяем баланс средств на картах
        if (from.getBalance() - payment < 0) {
            throw new RuntimeException("Insufficient funds.");
        }
        if (to.getBalance() > Integer.MAX_VALUE - payment) {
            throw new RuntimeException("Too much amount.");
        }
        // Блок finally выполнится в любом случае, даже если произойдет исключение.
        // Помещая операции по переводу денег в блок finally, мы создаем дополнительную безопасность
        // проведения транзакции.
        try {
        } finally {
            clients.remove(from);
            clients.remove(to);
            from.setBalance(from.getBalance() - payment);
            to.setBalance(to.getBalance() + payment);
            clients.add(from);
            clients.add(to);
        }
        return true;
    }
}
