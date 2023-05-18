package models;

import presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {
    private Collection<Table> tables;

    public Collection<Table> loadTables(){
        if(tables == null) {
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;

    }
    public int reservationTable(Date reservationDate, int tableNumber, String name){
        for(Table table: tables){
            if(table.getNumber() == tableNumber){
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }

        }
        return -1;
    }

    @Override
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNumber, String name) {
        for (Table table : tables) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == oldReservation) {
                    table.getReservations().remove(reservation);
                    break;
                }
            }
        }
        ;
        return reservationTable(reservationDate, tableNumber, name);
    }

}

