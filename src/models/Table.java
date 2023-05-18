package models;

import java.util.ArrayList;
import java.util.Collection;

public class Table {
    private static int counter;
    private final Collection<Reservation> reservations = new ArrayList<>();
    private final int number;

    {
        number = ++counter;
    }

    public int getNumber() {
        return number;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public String toString() {
        return String.format("Table #%d", number);
    }
}
