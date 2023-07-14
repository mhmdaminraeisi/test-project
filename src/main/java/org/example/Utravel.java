package org.example;

import org.example.filter.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utravel {
    private List<Flight> flights = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private User onlineUser = null;
    private int numOfTickets = 1;
    private List<Filter> filters;
    public Utravel() {
        AirlineFilter airlineFilter = new AirlineFilter();
        OriginDestinationFilter originDestinationFilter = new OriginDestinationFilter();
        CostRangeFilter costRangeFilter = new CostRangeFilter();
        TimeSpanFilter timeSpanFilter = new TimeSpanFilter();
        filters = Arrays.asList(airlineFilter,
                originDestinationFilter,
                costRangeFilter,
                timeSpanFilter);
    }
    public void readFlights(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            int id = 1;
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                Flight flight = new Flight(id);
                flight.read(line);
                flights.add(flight);
                id += 1;
            }
        }
    }
    public String signup(String name, String pass) {
        if (usernameExists(name)) {
            throw new RuntimeException(Headers.BAD_REQUEST);
        }
        User user = new User(name, pass);
        users.add(user);
        onlineUser = user;
        return Headers.OK;
    }
    public String login(String name, String pass) {
        for (User user : users) {
            if (user.isLoggedIn(name, pass)) {
                onlineUser = user;
                return Headers.OK;
            }
        }
        throw new RuntimeException(Headers.BAD_REQUEST);
    }
    public String logout() {
        if (nobodyIsOnline()) {
            throw new RuntimeException(Headers.PERMISSION_DENIED);
        }
        deleteFilters();
        onlineUser = null;
        return Headers.OK;
    }
    public String wallet(double amount) {
        if (nobodyIsOnline()) {
            throw new RuntimeException(Headers.PERMISSION_DENIED);
        }
        onlineUser.increaseCredit(amount);
        return Headers.OK;
    }
    public String printFlights() {
        if (nobodyIsOnline()) {
            throw new RuntimeException(Headers.PERMISSION_DENIED);
        }
        if (flights.isEmpty()) {
            throw new RuntimeException(Headers.EMPTY);
        }
        StringBuilder builder = new StringBuilder();
        for (Flight flight : flights) {
            builder.append(flight.toString(false));
        }
        if (builder.toString().equals(Headers.EMPTY_STRING)) {
            throw new RuntimeException(Headers.EMPTY);
        }
        return builder.toString();
    }
    public String printFlight(int id) {
        if (nobodyIsOnline()) {
            throw new RuntimeException(Headers.PERMISSION_DENIED);
        }
        if (idIsUnAvailable(id)) {
            throw new RuntimeException(Headers.NOT_FOUND);
        }
        return flights.get(id - 1).toString(true);
    }
    public String buyTicket(int flightId, int quantity, String fClass, String tType) {
        if (nobodyIsOnline()) {
            throw new RuntimeException(Headers.PERMISSION_DENIED);
        }
        if (idIsUnAvailable(flightId)) {
            throw new RuntimeException(Headers.NOT_FOUND);
        }
        numOfTickets += 1;
        return onlineUser.buyTicket(numOfTickets - 1, flights.get(flightId - 1), quantity, fClass, tType);
    }
    public String printTickets() {
        if (nobodyIsOnline()) {
            throw new RuntimeException(Headers.PERMISSION_DENIED);
        }
        return onlineUser.printTickets();
    }
    public String printTicket(int id) {
        if (nobodyIsOnline()) {
            throw new RuntimeException(Headers.PERMISSION_DENIED);
        }
        return onlineUser.printTicket(id);
    }
    public String cancelTicket(int id) {
        if (nobodyIsOnline()) {
            throw new RuntimeException(Headers.PERMISSION_DENIED);
        }
        return onlineUser.cancelTicket(id);
    }
    public String applyFilter(Input input) {
        if (nobodyIsOnline()) {
            throw new RuntimeException(Headers.PERMISSION_DENIED);
        }
        for (Filter filter : filters) {
            filter.read(input);
        }
        boolean filterApplied = false;
        for (Filter filter : filters) {
            if (filter.apply(flights)) {
                filterApplied = true;
            }
        }
        if (!filterApplied) {
            throw new RuntimeException(Headers.BAD_REQUEST);
        }
        return Headers.OK;
    }
    public String deleteFilters() {
        if (nobodyIsOnline()) {
            throw new RuntimeException(Headers.PERMISSION_DENIED);
        }
        for (Flight flight : flights) {
            flight.deleteFilters();
        }
        return Headers.OK;
    }
    private boolean usernameExists(String name) {
        for (User user : users) {
            if (user.nameIsSame(name)) {
                return true;
            }
        }
        return false;
    }
    private boolean nobodyIsOnline() {
        return onlineUser == null;
    }
    private boolean idIsUnAvailable(int id) {
        return id >= flights.size() || id < 0;
    }
}
