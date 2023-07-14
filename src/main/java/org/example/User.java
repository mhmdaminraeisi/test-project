package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private double credit = 0.0;
    private List<Ticket> tickets = new ArrayList<>();

    public User(String name, String pass) {
        username = name;
        password = pass;
    }
    public boolean isLoggedIn(String name, String pass) {
        return username.equals(name) && password.equals(pass);
    }
    public boolean nameIsSame(String name) {
        return username.equals(name);
    }
    public void increaseCredit(double amount) {
        if (amount <= 0) {
            throw new RuntimeException(Headers.BAD_REQUEST);
        }
        credit += amount;
    }
    public String buyTicket(int id, Flight flight, int quantity, String fClass, String tType) {
        Ticket ticket = new Ticket(id, quantity, flight, fClass, tType);
        ticket.calculateCost(credit);
        tickets.add(ticket);
        return id + "\n";
    }
    public String printTickets() {
        if (tickets.isEmpty()) {
            throw new RuntimeException(Headers.EMPTY);
        }
        StringBuilder builder = new StringBuilder();
        for (Ticket ticket : tickets) {
            builder.append(ticket);
        }
        return builder.toString();
    }
    public String printTicket(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket.toString();
            }
        }
        throw new RuntimeException(Headers.NOT_FOUND);
    }
    public String cancelTicket(int id) {
        for (int i = 0; i < tickets.size(); i++) {
            Ticket ticket = tickets.get(i);
            if (ticket.getId() == id) {
                ticket.cancel();
                credit += ticket.getPrice() / 2;
                tickets.remove(i);
                return Headers.OK;
            }
        }
        throw new RuntimeException(Headers.NOT_FOUND);
    }
}
