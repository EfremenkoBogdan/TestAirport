package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Method checks which departures occur before the current time.
 */
public class FilterBeforeNowTime implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flightList) {
        LocalDateTime currentMoment = LocalDateTime.now();
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : flightList) {
            boolean isBeforeCurrentMoment = false;
            for (Segment segment : flight.getSegments()) {
                if (segment.getDepartureDate().isBefore(currentMoment)) {
                    isBeforeCurrentMoment = true;
                    break;
                }
            }
            if (isBeforeCurrentMoment) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }
}
