package org.example.filter;

import org.example.Flight;

import java.util.List;

public abstract class Filter {
    public abstract void read(Input input);
    public abstract boolean apply(List<Flight> flights);
}
