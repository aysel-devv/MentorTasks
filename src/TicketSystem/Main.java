package TicketSystem;

import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern flightClassPattern = Pattern.compile("ECONOMY|PREMIUM_ECONOMY|BUSINESS|FIRST_CLASS}");
        Pattern destinationPattern = Pattern.compile("NEW_YORK|LONDON|TOKYO|PARIS|SYDNEY");
        Pattern seatPreferencePattern = Pattern.compile("WINDOW|AISLE|MIDDLE");
        Pattern emailAddressPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

        System.out.println("Welcome!");

        FlightClass flightClass = null;

        while (flightClass == null) {
            System.out.println("Choose a flight class: ECONOMY, PREMIUM_ECONOMY, BUSINESS or FIRST_CLASS");
            String input1 = scanner.nextLine().toUpperCase();

            if (flightClassPattern.matcher(input1).matches()) {
                flightClass = FlightClass.valueOf(input1);
            } else {
                System.out.println("Invalid option!");
            }
        }

        Destination destination = null;

        while (destination == null) {
            System.out.println("Choose a destination: NEW_YORK, LONDON, TOKYO, PARIS or SYDNEY");

            String input1 = scanner.nextLine().toUpperCase();
            if (destinationPattern.matcher(input1).matches()) {
                destination = Destination.valueOf(input1);
            } else {
                System.out.println("Invalid option!");
            }
        }

        SeatPreference seatPreference = null;

        while (seatPreference == null) {
            System.out.println("Choose a seat preference: WINDOW, AISLE or MIDDLE");

            String input1 = scanner.nextLine().toUpperCase();
            if (seatPreferencePattern.matcher(input1).matches()) {
                seatPreference = SeatPreference.valueOf(input1);
            } else {
                System.out.println("Invalid option!");
            }
        }

        int numberOfTickets = 0;

        while(numberOfTickets==0){
            System.out.println("Enter number of tickets: 1, 2, 3, 4 or 5");
            int input1=scanner.nextInt();
            if (input1>0 && input1<=5){
                numberOfTickets=input1;
            }else{
                System.out.println("Invalid option!");
            }
        }

        String emailAddress=null;

        while(emailAddress==null){
            System.out.println("Enter an email: ");
            String email1=scanner.next();

            if (emailAddressPattern.matcher(email1).matches()){
                emailAddress=email1;
            }else{
                System.out.println("Invalid email address!");
            }

        }

        double price= destination.getPrice()*numberOfTickets;
        switch (seatPreference){
            case WINDOW -> price+=50;
            case AISLE -> price+=25;
        }

        switch (flightClass){
            case PREMIUM_ECONOMY -> price*=1.5;
            case BUSINESS -> price*=2;
            case FIRST_CLASS -> price*=3;

        }


        System.out.println("Price: "+price);



    }
}