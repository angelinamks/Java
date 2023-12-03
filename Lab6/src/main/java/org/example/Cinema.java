package org.example;

public class Cinema {
    private final int[][][] seats;

    public Cinema(int numHalls, int numRows, int numSeatsPerRow) {
        seats = new int[numHalls][numRows][numSeatsPerRow];
    }

    public void bookSeats(int hallNumber, int row, int[] seatsToBook) {
        for (int seat : seatsToBook) {
            if (seats[hallNumber - 1][row - 1][seat - 1] == 0) {
                seats[hallNumber - 1][row - 1][seat - 1] = 1;
            } else {
                System.out.println("Seat " + seat + " in row " + row + " in hall " + hallNumber + " is already booked.");
            }
        }
    }

    public void cancelBooking(int hallNumber, int row, int[] seatsToCancel) {
        for (int seat : seatsToCancel) {
            if (seats[hallNumber - 1][row - 1][seat - 1] == 1) {
                seats[hallNumber - 1][row - 1][seat - 1] = 0;
            } else {
                System.out.println("Seat " + seat + " in row " + row + " in hall " + hallNumber + " is not booked.");
            }
        }
    }

    public boolean checkAvailability(int hallNumber, int numSeats) {
        for (int row = 0; row < seats[hallNumber - 1].length; row++) {
            int consecutiveSeats = 0;
            for (int seat = 0; seat < seats[hallNumber - 1][row].length; seat++) {
                if (seats[hallNumber - 1][row][seat] == 0) {
                    consecutiveSeats++;
                    if (consecutiveSeats == numSeats) {
                        return true;
                    }
                } else {
                    consecutiveSeats = 0;
                }
            }
        }
        return false;
    }

    public boolean isSeatAvailable(int hallNumber, int row, int seat) {
        return seats[hallNumber - 1][row - 1][seat - 1] == 0;
    }

    public void printSeatingArrangement(int hallNumber) {
        for (int row = 0; row < seats[hallNumber - 1].length; row++) {
            for (int seat = 0; seat < seats[hallNumber - 1][row].length; seat++) {
                System.out.print(seats[hallNumber - 1][row][seat] + " ");
            }
            System.out.println();
        }
    }
}
