package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CinemaTest {
    private Cinema cinema;

    @BeforeEach
    void setUp() {
        cinema = new Cinema(5, 10, 20);
    }

    @Test
    void bookingAnAvailableSeatShouldSucceed() {
        int hallNumber = 1;
        int row = 4;
        int seatNumber = 5;

        assertTrue(cinema.isSeatAvailable(hallNumber, row, seatNumber));

        cinema.bookSeats(hallNumber, row, new int[]{seatNumber});

        assertFalse(cinema.isSeatAvailable(hallNumber, row, seatNumber));
    }

    @Test
    void shouldNotAllowBookingOfAlreadyBookedSeat() {
        int hallNumber = 1;
        int row = 4;
        int seatNumber = 5;

        cinema.bookSeats(hallNumber, row, new int[]{seatNumber});

        assertFalse(cinema.isSeatAvailable(hallNumber, row, seatNumber));

        cinema.bookSeats(hallNumber, row, new int[]{seatNumber});

        assertFalse(cinema.isSeatAvailable(hallNumber, row, seatNumber));
    }

    @Test
    void shouldAllowBookingOfCancelledSeat() {
        int hallNumber = 1;
        int row = 4;
        int seatNumber = 5;

        cinema.bookSeats(hallNumber, row, new int[]{seatNumber});

        cinema.cancelBooking(hallNumber, row, new int[]{seatNumber});

        assertTrue(cinema.isSeatAvailable(hallNumber, row, seatNumber));

        cinema.bookSeats(hallNumber, row, new int[]{seatNumber});

        assertFalse(cinema.isSeatAvailable(hallNumber, row, seatNumber));
    }

    @Test
    void allSeatsBookedShouldNotFindFourConsecutiveAvailableSeats() {
        int hallNumber = 1;
        for (int r = 1; r <= 10; r++) {
            for (int s = 1; s <= 20; s++) {
                cinema.bookSeats(hallNumber, r, new int[]{s});
            }
        }

        assertFalse(cinema.checkAvailability(hallNumber, 4));
    }
}








