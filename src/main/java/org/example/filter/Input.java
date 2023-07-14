package org.example.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.Time;

@Getter
@Setter
@AllArgsConstructor
public class Input {
    private String airline;
    private String origin;
    private String destination;
    private double minPrice;
    private double maxPrice;
    private boolean minPriceEntered;
    private boolean maxPriceEntered;
    private int departureDate;
    private Time minTime;
    private Time maxTime;
    private boolean minTimeEntered;
    private boolean maxTimeEntered;
}
