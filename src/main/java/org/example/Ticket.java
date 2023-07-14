package org.example;

import lombok.Getter;

public class Ticket {
    @Getter
    private int id;
    private int quantity;
    @Getter
    private double price;
    private Flight flight;
    private String flightClass;
    private String ticketType;
    public Ticket(int i, int q, Flight f, String fc, String tt) {
        if (!flightClassIsOk(fc) || !ticketTypeIsOk(tt) || i <= 0 || q <= 0) {
            throw new RuntimeException(Headers.BAD_REQUEST);
        }
        f.updateCapacity(q, fc);
        id = i;
        price = f.calculateCost(q, fc);
        quantity = q;
        flight = f;
        flightClass = fc;
        ticketType = tt;
    }
    public void calculateCost(double credit) {
        if (price > credit) {
            throw new RuntimeException(Headers.BAD_REQUEST);
        }
        credit -= price;
    }

    @Override
    public String toString() {
        return id + Headers.SHOW_DELIMITER +
                flight.printForTicket(quantity) +
                flightClass + Headers.SHOW_DELIMITER +
                ticketType + Headers.SHOW_DELIMITER +
                Math.round(price * 100.0) / 100.0 + "\n";
    }
    public boolean cancel() {
        if (ticketType.equals(Headers.SYSTEMI)) {
            throw new RuntimeException(Headers.BAD_REQUEST);
        }
        flight.updateCapacity(-quantity, flightClass);
        return true;
    }
    private boolean flightClassIsOk(String fClass) {
        return fClass.equals(Headers.ECONOMY) || fClass.equals(Headers.BUSINESS);
    }
    private boolean ticketTypeIsOk(String tType) {
        return tType.equals(Headers.SYSTEMI) || tType.equals(Headers.CHARTERY);
    }
}
