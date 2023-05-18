package views;

import models.Table;
import presenters.View;
import presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {
    private ViewObserver observer;

    /**
     * отобразить список столиков
     * @param tables - список столов;
     */
    public void showTables(Collection<Table> tables){
        for(Table table: tables){
            System.out.println(table);
        }

    }

    /**
     * отобразить результат бронирования
     * @param reservationNumber номер брони
     */
    @Override
    public void showReservationStatus(int reservationNumber) {
        if(reservationNumber > 0){
            System.out.printf("столик успешно забронирован, номер брони: #%d\n", reservationNumber);
        }
        else {
            System.out.println("ошибка бронирования столика");
        }

    }

    @Override
    public void showEditReservationStatus(int oldReservation, int reservationNumber) {
        if (reservationNumber > 0) {
            System.out.printf("Бронь #%d отменена. Новый номер брони: #%d\n", oldReservation, reservationNumber);
        } else {
            System.out.println("Ошибка бронирования столика.");
        }
    }

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    /**
     * Действие клиента(пользователь нажал на кнопку бронирования);
     * бронирование стола;
     * @param name имя клиента;
     * @param orderDate дата бронирования;
     * @param tableNumber номер стола;
     */

    public void reservationTable(Date orderDate, int tableNumber,String name){
        observer.onReeservationTable(orderDate,tableNumber,name);

    }

    /**
     * действие клиента(пользователь нажал на кнопку бронирования), бронирование столика
     * @param oldReservation идентификатор бронирования (старый)
     * @param reservationDate дата бронирования
     * @param tableNumber номер столика
     * @param name имя клиента
     */
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNumber, String name){
        observer.onChangeReservationTable(oldReservation, reservationDate, tableNumber, name);

    }
}
