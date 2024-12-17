package TicketSystem;

public enum Destination {
    NEW_YORK(500),
    LONDON(600),
    TOKYO(700),
    PARIS(550),
    SYDNEY(1000),
    ;

    private final double price;
    Destination(double price) {
        this.price=price;
    }

    public double getPrice(){
        return price;
    }


}
