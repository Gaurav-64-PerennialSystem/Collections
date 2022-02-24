package com.timbuchalka;

import java.util.*;

/**
 * Created by dev on 2/12/2015.
 */
public class Theatre {
    private static Logger logger=myLoggerClass.getLOGGER();
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows -1);
        for (char row = 'A'; row <= lastRow; row++) {
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = null;
        for(Seat seat : seats) {
            if(seat.getSeatNumber().equals(seatNumber)) {
                requestedSeat = seat;
                break;
            }
        }

        if(requestedSeat == null) {
            logger.log(Level.INFO,"There is no seat " + seatNumber);
            return false;
        }

        return requestedSeat.reserve();
    }

    
    public void getSeats() {
        for(Seat seat : seats) {
            logger.log(Level.INFO,"There is no seat " +seat.getSeatNumber());
        }
    }

    private class Seat {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public boolean reserve() {
            if(!this.reserved) {
                this.reserved = true;
                logger.log(Level.INFO,"Seat " + seatNumber + " reserved");
                
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if(this.reserved) {
                this.reserved = false;
                logger.log(Level.INFO,"Reservation of seat " + seatNumber + " cancelled");
    
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }
    }



















}
