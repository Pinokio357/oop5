package presenters;

import models.Table;

import java.util.Collection;

public interface View {
    /**
     * отобразить список всех столов;
     * @param tables - список столов;
     */


    void showTables(Collection<Table> tables);

    void showReservationStatus(int reservationNumber);
    void showEditReservationStatus(int oldReservation, int reservationNo);

    /**
     * установить нового наблюдателя;
     * @param observer наблюдатель(presenter);
     */
    void setObserver(ViewObserver observer);
}
