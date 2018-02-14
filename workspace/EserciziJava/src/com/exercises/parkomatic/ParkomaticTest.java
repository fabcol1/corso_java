package com.exercises.parkomatic;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class ParkomaticTest {

    /*
    * The Parkomatic should support up to 6 floors : A, B, C, D, E, F
    * Floor size can contain up to 200 cars
    * A slot index is an integer number that represent the absolute position of the car in the parking lot
    * You have to implement the print(int slotIndex) to print the slot identifier, that's composed by:
    * FLOOR_NAME + RELATIVE_POSITION_OF_THE_CAR_IN_THE_FLOOR
    * 
    * Provide more tests to prove that the implementation is correct
    */

    @Test
    public void printTicket() {
        Parkomatic parkomatic = new Parkomatic(100, 50, 50);
        assertEquals("A1", parkomatic.print(0));
        assertEquals("C50", parkomatic.print(199));
        assertEquals("A51", parkomatic.print(50));
        assertEquals("A35", parkomatic.print(34));
        assertEquals("B15", parkomatic.print(114));
        assertEquals("C1", parkomatic.print(150));
        assertEquals("C50", parkomatic.print(199));
    }
}
