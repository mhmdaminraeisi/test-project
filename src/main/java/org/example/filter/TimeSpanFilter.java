package org.example.filter;

import org.example.Flight;
import org.example.Headers;
import org.example.Time;

import java.util.List;

public class TimeSpanFilter extends Filter {
    private int departureDate;
    private Time minTime;
    private Time maxTime;
    private boolean minTimeEntered;
    private boolean maxTimeEntered;
    @Override
    public void read(Input input) {
        departureDate = input.getDepartureDate();
        minTime = input.getMinTime();
        maxTime = input.getMaxTime();
        minTimeEntered = input.isMinTimeEntered();
        maxTimeEntered = input.isMaxTimeEntered();
    }

    @Override
    public boolean apply(List<Flight> flights) {
        if (departureDate == Headers.NOT_ENTERED && (minTimeEntered || maxTimeEntered)) {
            throw new RuntimeException(Headers.BAD_REQUEST);
        }
        if (departureDate == Headers.NOT_ENTERED && !minTimeEntered && !maxTimeEntered) {
            return false;
        }
        if (!minTimeEntered) {
            minTime = new Time(0, 0);
        }
        if (!maxTimeEntered) {
            maxTime = new Time(23, 59);
        }
        for (Flight flight : flights) {
            flight.applyTimeSpanFilter(departureDate, minTime, maxTime);
        }
        return true;
    }
}
