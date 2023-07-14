package org.example.filter;

import org.example.Flight;
import org.example.Headers;

import java.util.List;

public class AirlineFilter extends Filter {
    private String airline;
    @Override
    public void read(Input input) {
        airline = input.getAirline();
    }

    @Override
    public boolean apply(List<Flight> flights) {
        if (airline.equals(Headers.EMPTY_STRING)) {
            return false;
        }
        for (Flight flight : flights) {
            flight.applyAirlineFilter(airline);
        }
        return true;
    }
}
