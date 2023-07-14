package org.example;

import org.example.filter.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Functions {
    public static String splitFirstSign(String input) {
        if (input.charAt(1) != Headers.THE_SIGN) {
            throw new RuntimeException(Headers.BAD_REQUEST);
        }
        return input.substring(input.indexOf(Headers.THE_SIGN) + 2);
    }
    public static int readId(String input) {
        input = splitFirstSign(input);
        String[] inputs = input.split(Headers.SHOW_DELIMITER);
        if (!inputs[0].equals(Headers.ID)) {
            throw new RuntimeException(Headers.BAD_REQUEST);
        }
        return Integer.parseInt(inputs[1]);
    }
    public static List<String> readNameAndPass(String input) {
        String[] inputs = input.split(Headers.SHOW_DELIMITER);
        if (inputs.length != 4) {
            throw new RuntimeException(Headers.BAD_REQUEST);
        }
        if (!inputs[0].equals(Headers.USERNAME) || !inputs[2].equals(Headers.PASSWORD)) {
            throw new RuntimeException(Headers.BAD_REQUEST);
        }
        return new ArrayList<>(Arrays.asList(inputs[1], inputs[3]));
    }
    public static String signup(String input, Utravel utravel) {
        input = splitFirstSign(input);
        List<String> nameAndPass = readNameAndPass(input);
        return utravel.signup(nameAndPass.get(0), nameAndPass.get(1));
    }
    public static String login(String input, Utravel utravel) {
        input = splitFirstSign(input);
        List<String> nameAndPass = readNameAndPass(input);
        return utravel.login(nameAndPass.get(0), nameAndPass.get(1));
    }
    public static String wallet(String input, Utravel utravel) {
        input = splitFirstSign(input);
        String[] inputs = input.split(Headers.SHOW_DELIMITER);
        if (inputs.length != 2 || !inputs[0].equals(Headers.AMOUNT) || inputs[1].length() == 0) {
            throw new RuntimeException(Headers.BAD_REQUEST);
        }
        return utravel.wallet(Double.parseDouble(inputs[1]));
    }
    public static String showFlights(String input, Utravel utravel) {
        if (input.length() == 0) {
            return utravel.printFlights();
        }
        int id = readId(input);
        return utravel.printFlight(id);
    }
    public static String buyTicket(String input, Utravel utravel) {
        input = splitFirstSign(input);
        String[] inputs = input.split(Headers.SHOW_DELIMITER);
        if (inputs.length != 8) {
            throw new RuntimeException(Headers.BAD_REQUEST);
        }
        if (!inputs[0].equals(Headers.FLIGHT) ||
            !inputs[2].equals(Headers.QUANTITY) ||
            !inputs[4].equals(Headers.CLASS) ||
            !inputs[6].equals(Headers.TYPE)) {
            throw new RuntimeException(Headers.BAD_REQUEST);
        }
        return utravel.buyTicket(Integer.parseInt(inputs[1]),
                Integer.parseInt(inputs[3]), inputs[5], inputs[7]);
    }
    public static String showTickets(String input, Utravel utravel) {
        if (input.length() == 0) {
            return utravel.printTickets();
        }
        int id = readId(input);
        return utravel.printTicket(id);
    }
    public static String cancelTicket(String input, Utravel utravel) {
        int id = readId(input);
        return utravel.cancelTicket(id);
    }
    public static String applyFilter(String inp, Utravel utravel) {
        inp = splitFirstSign(inp);
        String[] inputs = inp.split(Headers.SHOW_DELIMITER);
        if (inputs.length % 2 == 1) {
            throw new RuntimeException(Headers.BAD_REQUEST);
        }
        Input input = Headers.EMPTY_INPUT;
        for (int i = 0; i < inputs.length; i += 2) {
            if (inputs[i+1].length() == 0) {
                throw new RuntimeException(Headers.BAD_REQUEST);
            }
            String title = inputs[i];
            switch (title) {
                case Headers.FROM:
                    input.setOrigin(inputs[i+1]);
                    break;
                case Headers.TO:
                    input.setDestination(inputs[i+1]);
                    break;
                case Headers.MIN_PRICE:
                    input.setMinPrice(Double.parseDouble(inputs[i+1]));
                    break;
                case Headers.MAX_PRICE:
                    input.setMaxPrice(Double.parseDouble(inputs[i+1]));
                    break;
                case Headers.AIRLINE:
                    input.setAirline(inputs[i+1]);
                    break;
                case Headers.DEPARTURE_DATE:
                    input.setDepartureDate(Integer.parseInt(inputs[i+1]));
                    break;
                case Headers.MIN_DEPARTURE_TIME:
                    input.getMinTime().set(inputs[i+1]);
                    input.setMinTimeEntered(true);
                    break;
                case Headers.MAX_DEPARTURE_TIME:
                    input.getMaxTime().set(inputs[i+1]);
                    input.setMaxTimeEntered(true);
                    break;
                default:
                    throw new RuntimeException(Headers.BAD_REQUEST);
            }
        }
        return utravel.applyFilter(input);
    }
    public static String doGetCommands(String command, String input, Utravel utravel) {
        if (command.equals(Headers.FLIGHTS)) {
            return showFlights(input, utravel);
        }
        if (command.equals(Headers.TICKETS)) {
            return showTickets(input, utravel);
        }
        throw new RuntimeException(Headers.NOT_FOUND);
    }
    public static String doPostCommand(String command, String input, Utravel utravel) {
        if (command.equals(Headers.SIGNUP)) {
            return signup(input, utravel);
        }
        if (command.equals(Headers.LOGIN)) {
            return login(input, utravel);
        }
        if (command.equals(Headers.LOGOUT)) {
            return utravel.logout();
        }
        if (command.equals(Headers.WALLET)) {
            return wallet(input, utravel);
        }
        if (command.equals(Headers.FILTERS)) {
            return applyFilter(input, utravel);
        }
        if (command.equals(Headers.TICKETS)) {
            return buyTicket(input, utravel);
        }
        throw new RuntimeException(Headers.NOT_FOUND);
    }
    public static String doDeleteCommand(String command, String input, Utravel utravel) {
        if (command.equals(Headers.TICKETS)) {
            return cancelTicket(input, utravel);
        }
        if (command.equals(Headers.FILTERS)) {
            return utravel.deleteFilters();
        }
        throw new RuntimeException(Headers.NOT_FOUND);
    }
    public static String doCommand(String commandLine, Utravel utravel) {
        String firstPart = commandLine.split(Headers.SHOW_DELIMITER)[0];
        String command = commandLine.split(Headers.SHOW_DELIMITER)[1];
        String another = commandLine.substring(firstPart.length() + command.length() + 1);
        if (firstPart.equals(Headers.GET)) {
            return doGetCommands(command, another, utravel);
        }
        if (firstPart.equals(Headers.POST)) {
            return doPostCommand(command, another, utravel);
        }
        if (firstPart.equals(Headers.DELETE)) {
            return doDeleteCommand(command, another, utravel);
        }
        throw new RuntimeException(Headers.BAD_REQUEST);
    }
}
