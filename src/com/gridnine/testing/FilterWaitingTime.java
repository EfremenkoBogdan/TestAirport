package com.gridnine.testing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Method checks for long waits between segments.
 */
public class FilterWaitingTime implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flightList) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : flightList) {
            if (flight.getSegments().size() > 1 && longerThenTimeWaiting(flight.getSegments())) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }

    /**
     * Internal method to check whether a segment has waited for more than 2 hours.
     */
    private static boolean longerThenTimeWaiting(List<Segment> segments) {
        int timeWaiting = 2;
        long totalTime = 0;
        for (int j = 1; j < segments.size(); j++) {
            totalTime = totalTime + Duration.between(segments.get(j - 1).getArrivalDate(),
                    segments.get(j).getDepartureDate()).toHours();
        }
        return totalTime > timeWaiting;
    }
}
