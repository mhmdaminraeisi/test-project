package org.example.filter;

import org.example.Flight;
import org.example.Headers;

import java.util.List;
import java.util.logging.Handler;

public class OriginDestinationFilter extends Filter {
    private String origin;
    private String destination;

    @Override
    public void read(Input input) {
        origin = input.getOrigin();
        destination = input.getDestination();
    }

    @Override
    public boolean apply(List<Flight> flights) {
        if (origin.equals(Headers.EMPTY_STRING) || destination.equals(Headers.EMPTY_STRING)) {
            return false;
        }
        for (Flight flight : flights) {
            flight.applyOriginDestinationFilter(origin, destination);
        }
        return true;
    }
}
