package org.example.filter;

import org.example.Flight;
import org.example.Headers;

import java.util.List;

public class CostRangeFilter extends Filter {
    private double minPrice;
    private double maxPrice;
    private boolean minPriceEntered;
    private boolean maxPriceEntered;
    @Override
    public void read(Input input) {
        minPrice = input.getMinPrice();
        maxPrice = input.getMaxPrice();
        minPriceEntered = input.isMinPriceEntered();
        maxPriceEntered = input.isMaxPriceEntered();
    }

    @Override
    public boolean apply(List<Flight> flights) {
        if (!minPriceEntered && !maxPriceEntered) {
            return false;
        }
        if (minPriceEntered && minPrice < 0 ||
            maxPriceEntered && maxPrice < 0 ||
            minPriceEntered && maxPriceEntered && minPrice > maxPrice) {
            throw new RuntimeException(Headers.BAD_REQUEST);
        }
        for (Flight flight : flights) {
            flight.applyCostRangeFilter(minPrice, maxPrice, minPriceEntered, maxPriceEntered);
        }
        return true;
    }
}
