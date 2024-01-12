package com.gridnine.testing;

import java.util.List;

public class Main
{
    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();

        System.out.println("==All flights==");
        System.out.println(flightList.toString());

        System.out.println("==Already flew away==");
        System.out.println((new FilterBeforeNowTime().filter(flightList)).toString());

        System.out.println("==Arrival before departure==");
        System.out.println((new FilterArrivalBeforeDeparture().filter(flightList)).toString());

        System.out.println("==Long waiting time==");
        System.out.println((new FilterWaitingTime().filter(flightList)).toString());

    }
}
