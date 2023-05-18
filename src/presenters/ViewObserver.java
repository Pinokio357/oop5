package presenters;

import java.util.Date;

public interface ViewObserver {
    void onReeservationTable(Date orderDate, int tableNumber, String name);

    void onChangeReservationTable(int oldReservation,Date orderDate, int tableNumber, String name);
}
