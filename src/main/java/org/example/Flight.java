package org.example;

import javax.management.RuntimeErrorException;
import java.util.Objects;

import static jdk.nashorn.internal.objects.NativeMath.round;

public class Flight {
    private int id;
    private String airline = Headers.EMPTY_STRING;
    private String origin = Headers.EMPTY_STRING;
    private String destination = Headers.EMPTY_STRING;
    private int departureDate = 0;
    private int arrivalDate = 0;
    private Time departureTime = new Time(0, 0);
    private Time arrivalTime = new Time(0, 0);
    private int seats = 0;
    private int economySeats = 0;
    private int businessSeats = 0;
    private double cost = 0.0;
    private boolean airlineFilterApplied = true;
    private boolean timeSpanFilterApplied = true;
    private boolean costRangeFilterApplied = true;
    private boolean originDestinationFilterApplied = true;

    public Flight(int i) {
        id = i;
    }

    public void read(String input) {
        String[] values = input.split(Headers.DELIMITER);
        airline = values[0];
        origin = values[1];
        destination = values[2];
        departureDate = Integer.parseInt(values[3]);
        departureTime.set(values[4]);
        arrivalDate = Integer.parseInt(values[5]);
        arrivalTime.set(values[6]);
        seats = Integer.parseInt(values[7]);
        businessSeats = seats / 4;
        economySeats = seats - businessSeats;
        cost = Double.parseDouble(values[8]);
    }

    public String toString(boolean show) {
        if (!show && (flightIsFiltered() || flightIsFull())) {
            return Headers.EMPTY_STRING;
        }
        return id + Headers.SHOW_DELIMITER +
                airline + Headers.SHOW_DELIMITER +
                origin + Headers.SHOW_DELIMITER +
                destination + Headers.SHOW_DELIMITER +
                departureDate + Headers.SHOW_DELIMITER +
                departureTime + Headers.SHOW_DELIMITER +
                arrivalDate + Headers.SHOW_DELIMITER +
                arrivalTime + Headers.SHOW_DELIMITER +
                (economySeats + businessSeats) + Headers.SHOW_DELIMITER +
                Math.round(cost * 100.0) / 100.0 + "\n";
    }

    public String printForTicket(int quantity) {
        return id + Headers.SHOW_DELIMITER +
                airline + Headers.SHOW_DELIMITER +
                quantity + Headers.SHOW_DELIMITER +
                origin + Headers.SHOW_DELIMITER +
                destination + Headers.SHOW_DELIMITER +
                departureDate + Headers.SHOW_DELIMITER +
                departureTime + Headers.SHOW_DELIMITER +
                arrivalDate + Headers.SHOW_DELIMITER +
                arrivalTime;
    }

    public double calculateCost(int quantity, String fClass) {
        if (fClass.equals(Headers.ECONOMY)) {
            return quantity * cost;
        }
        if (fClass.equals(Headers.BUSINESS)) {
            return quantity * Headers.FRACTION * cost;
        }
        throw new RuntimeException(Headers.BAD_REQUEST);
    }

    public void updateCapacity(int quantity, String fClass) {
        if (hasEnoughSeats(quantity, fClass)) {
            if (fClass.equals(Headers.ECONOMY)) {
                economySeats -= quantity;
            } else {
                businessSeats -= quantity;
            }
        } else {
            throw new RuntimeException(Headers.BAD_REQUEST);
        }
    }

    public void applyAirlineFilter(String airlineName) {
        airlineFilterApplied = airline.equals(airlineName);
    }

    public void applyOriginDestinationFilter(String org, String des) {
        originDestinationFilterApplied = origin.equals(org) && destination.equals(des);
    }

    public void applyTimeSpanFilter(int date, Time minTime, Time maxTime) {
        timeSpanFilterApplied = departureDate == date &&
                minTime.lessThanEqual(departureTime) &&
                departureTime.lessThanEqual(maxTime);
    }

    public void applyCostRangeFilter(double min, double max, boolean minEntered, boolean maxEntered) {
        if (!minEntered) {
            costRangeFilterApplied = cost <= max;
        } else if (!maxEntered) {
            costRangeFilterApplied = min <= cost;
        } else {
            costRangeFilterApplied = min <= cost && cost <= max;
        }
    }

    public void deleteFilters() {
        airlineFilterApplied = true;
        originDestinationFilterApplied = true;
        costRangeFilterApplied = true;
        timeSpanFilterApplied = true;
    }

    private boolean hasEnoughSeats(int quantity, String fClass) {
        if (Objects.equals(fClass, Headers.ECONOMY)) {
            return quantity <= economySeats;
        }
        return quantity <= businessSeats;
    }
    private boolean flightIsFiltered() {
        return !(airlineFilterApplied && timeSpanFilterApplied &&
                costRangeFilterApplied && originDestinationFilterApplied);
    }
    private boolean flightIsFull() {
        return seats == 0;
    }
}
