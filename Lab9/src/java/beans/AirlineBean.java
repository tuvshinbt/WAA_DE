/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author tuvshuu
 */
@ManagedBean(name = "airline")
@RequestScoped
public class AirlineBean {

    private List<String> airlineList;
    private String currentAirline;
    private List<Flight> flightList;
    private List<Flight> currentFlightList;

    public AirlineBean() {
        airlineList = Arrays.asList("KLM", "North West", "United Airlines");
        flightList = Arrays.asList(new Flight("Amsterdam", "New York", new Date(), "KLM", 790.80),
                new Flight("Amsterdam", "New York", new Date(), "North West", 795.55),
                new Flight("Amsterdam", "New York", new Date(), "KLM", 820.00),
                new Flight("Amsterdam", "New York", new Date(), "United Airlines", 825.50),
                new Flight("Amsterdam", "New York", new Date(), "North West", 875.00),
                new Flight("Amsterdam", "New York", new Date(), "KLM", 989.00),
                new Flight("Amsterdam", "New York", new Date(), "United Airlines", 1050.25));
        currentFlightList = flightList;
    }

    public void changedAirline(ValueChangeEvent event) {
        System.out.println("CurrentAirline - " + event.getNewValue().toString());
        if (event.getNewValue().toString().equalsIgnoreCase("all")) {
            currentFlightList = flightList;
        } else {
            currentFlightList = new ArrayList<Flight>();
            for (Flight flight : flightList) {
                if (flight.getAirline().equalsIgnoreCase(event.getNewValue().toString())) {
                    currentFlightList.add(flight);
                }
            }
        }
        currentAirline = event.getNewValue().toString();
    }

    public List<String> getAirlineList() {
        return airlineList;
    }

    public void setAirlineList(List<String> airlineList) {
        this.airlineList = airlineList;
    }

    public String getCurrentAirline() {
        return currentAirline;
    }

    public void setCurrentAirline(String currentAirline) {
        this.currentAirline = currentAirline;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public List<Flight> getCurrentFlightList() {
        return currentFlightList;
    }

    public void setCurrentFlightList(List<Flight> currentFlightList) {
        this.currentFlightList = currentFlightList;
    }

}
