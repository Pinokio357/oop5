package presenters;

import models.Table;
import models.TableModel;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {
    private final Model model;
    private final View view;
    private Collection<Table> tables;

    public BookingPresenter(Model model, View view){
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * загрузить список всех столов;
     */

    public void loadTables(){
        if(tables == null){
            tables = model.loadTables();

        }

    }
    /*
    * отобразить список столов;
     */
    public void updateView(){
        view.showTables(tables);
    }

    /**
     * отобразить результат бронирования столика
     * @param reservationNumber номер брони
     */
    private void updateReservationStatusView(int reservationNumber){
        view.showReservationStatus(reservationNumber);

    }

    /**
     * получили уведомление о попытке бронирования столика
     * @param orderDate дата бронирования
     * @param tableNumber номер столика
     * @param name имя клиента
     */
    @Override
    public void onReeservationTable(Date orderDate, int tableNumber, String name) {
        int reservationNumber = model.reservationTable(orderDate, tableNumber, name);
        updateReservationStatusView(reservationNumber);

        }

    @Override
    public void onChangeReservationTable(int oldReservation, Date orderDate, int tableNumber, String name) {
        int reservationNumber = model.changeReservationTable(oldReservation, orderDate, tableNumber, name);
        updateEditReservationStatusView(oldReservation, reservationNumber);
    }

    private void updateEditReservationStatusView(int oldReservation, int reservationNumber) {
        view.showEditReservationStatus(oldReservation, reservationNumber);
    }

}

