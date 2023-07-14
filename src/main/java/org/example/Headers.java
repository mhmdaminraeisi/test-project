package org.example;

import org.example.filter.Input;

public class Headers {
    public static final String DELIMITER = ",";
    public static final String TIME_DELIMITER = ":";
    public static final int NOT_ENTERED = -1;
    public static final String EMPTY_STRING = "";
    public static final String SHOW_DELIMITER = " ";
    public static final String OK = "OK\n";
    public static final String BAD_REQUEST = "Bad Request\n";
    public static final String PERMISSION_DENIED = "Permission Denied\n";
    public static final String EMPTY = "Empty\n";
    public static final String NOT_FOUND = "Not Found\n";
    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String DELETE = "DELETE";
    public static final String SIGNUP = "signup";
    public static final String LOGIN = "login";
    public static final String LOGOUT = "logout";
    public static final String WALLET = "wallet";
    public static final String FLIGHTS = "flights";
    public static final String TICKETS = "tickets";
    public static final String FILTERS = "filters";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String AMOUNT = "amount";
    public static final String ID = "id";
    public static final String FLIGHT = "flight";
    public static final String QUANTITY = "quantity";
    public static final String CLASS = "class";
    public static final String TYPE = "type";
    public static final String ECONOMY = "economy";
    public static final String BUSINESS = "business";
    public static final String SYSTEMI = "nonrefundable";
    public static final String CHARTERY = "refundable";
    public static final String FROM = "from";
    public static final String TO = "to";
    public static final String MIN_PRICE = "min_price";
    public static final String MAX_PRICE = "max_price";
    public static final String AIRLINE = "airline";
    public static final String DEPARTURE_DATE = "departure_date";
    public static final String MIN_DEPARTURE_TIME = "min_departure_time";
    public static final String MAX_DEPARTURE_TIME = "max_departure_time";
    public static final double FRACTION = 2.5;
    public static final double NOT_ENTERED_FLOAT = -1;
    public static final char THE_SIGN = '?';
    public static final Input EMPTY_INPUT = new Input(
            EMPTY_STRING, EMPTY_STRING, EMPTY_STRING,
            NOT_ENTERED_FLOAT, NOT_ENTERED_FLOAT,
            false, false,
            NOT_ENTERED, new Time(), new Time(),
            false, false
    );
}
