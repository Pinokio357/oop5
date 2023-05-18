package presenters;

import models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {
    /**
     * получение всех столиков в ресторане
     */

    Collection<Table> loadTables();
    /**
     * бронирование столиков
     */

    int reservationTable(Date reservationDate, int tableNumber, String name);

    int changeReservationTable(int oldReservation, Date orderDate, int tableNumber, String name);
}
