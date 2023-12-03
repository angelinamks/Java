package org.example;


public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(5, 10, 20);

        System.out.println("Initial seating arrangement for hall 1:");
        cinema.printSeatingArrangement(1);

        System.out.println("\nAttempting to book seats 1, 2, 3, 4 in row 2 of hall 1...");
        cinema.bookSeats(1, 2, new int[]{1, 2, 3, 4});
        cinema.printSeatingArrangement(1);

        System.out.println("\nChecking availability for 4 consecutive seats in hall 1...");
        boolean isAvailable = cinema.checkAvailability(1, 4);
        System.out.println("Availability of 4 consecutive seats: " + isAvailable);

        System.out.println("\nCancelling booking of seats 1, 2, 3, 4 in row 2 of hall 1...");
        cinema.cancelBooking(1, 2, new int[]{1, 2, 3, 4});
        cinema.printSeatingArrangement(1);

        System.out.println("\nRechecking availability for 4 consecutive seats in hall 1 after cancellation...");
        isAvailable = cinema.checkAvailability(1, 4);
        System.out.println("Availability of 4 consecutive seats after cancellation: " + isAvailable);

    }
}
