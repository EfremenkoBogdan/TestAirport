package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

/**
 * Method checks which departures occur before departures.
 */
public class FilterArrivalBeforeDeparture implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flightList) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : flightList) {
            boolean hasInvalidSegment = false;
            for (Segment segment : flight.getSegments()) {
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                    hasInvalidSegment = true;
                    break;
                }
            }
            if (hasInvalidSegment) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }
}

