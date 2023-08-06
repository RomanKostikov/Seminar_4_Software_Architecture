package Interfaces;

import Models.Ticket;

import java.util.List;

/**
 * Интерфейс взаимодействия с базой билетов
 */
public interface ITicketRepo {
    /**
     * Создать новый билет
     *
     * @param ticket
     * @return
     */
    boolean create(Ticket ticket);

    /**
     * Получить список билетов по номеру маршрута
     *
     * @param routeNumber
     * @return
     */
    List<Ticket> readAll(int routeNumber);

    /**
     * Обновить билет
     *
     * @param ticket
     * @return
     */
    boolean update(Ticket ticket);

    /**
     * Удалить билет
     *
     * @param ticket
     * @return
     */
    boolean delete(Ticket ticket);
}
