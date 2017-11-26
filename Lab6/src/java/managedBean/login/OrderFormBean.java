/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean.login;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author tuvshuu
 */
@ManagedBean(name = "orderForm")
@RequestScoped
public class OrderFormBean {

    private final static List<String> fromCities;
    private final static List<String> toCities;
    private final static List<String> optionList;

    static {
        fromCities = Arrays.asList("Amsterdam", "Paris", "Lissabon");
        toCities = Arrays.asList("New York", "Boston", "Chicago");
        optionList = Arrays.asList("First class", "exact these dates", "no stopover");
        System.out.println("*** Initialized variables ***");
    }

    private String fromCity;
    private String toCity;
    private String departureDate;
    private String returnDate;
    private String typeOfTrip;
    private List<String> selectedOptionList;

    /**
     * Creates a new instance of OrderFormBean
     */
    public OrderFormBean() {
        this.typeOfTrip = "Round trip";
        this.selectedOptionList = new ArrayList<String>();
    }

    public String doRegister() {
        System.out.println("-------------------------");
        System.out.println("From: " + this.fromCity);
        System.out.println("To: " + this.toCity);
        System.out.println("DepartureDate: " + this.departureDate);
        System.out.println("ReturnDate: " + this.returnDate);
        System.out.println(this.typeOfTrip);
        System.out.println("Options: " + this.selectedOptionList.toString());
        return null;
    }

    public List<String> getFromCities() {
        return fromCities;
    }

//    public void setFromCities(List<String> fromCities) {
//        this.fromCities = fromCities;
//    }
    public List<String> getToCities() {
        return toCities;
    }

//    public void setToCities(List<String> toCities) {
//        this.toCities = toCities;
//    }
    public List<String> getOptionList() {
        return optionList;
    }

//    public void setOptionList(List<String> optionList) {
//        this.optionList = optionList;
//    }
    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getTypeOfTrip() {
        return typeOfTrip;
    }

    public void setTypeOfTrip(String typeOfTrip) {
        this.typeOfTrip = typeOfTrip;
    }

    public List<String> getSelectedOptionList() {
        return selectedOptionList;
    }

    public void setSelectedOptionList(List<String> selectedOptionList) {
        this.selectedOptionList = selectedOptionList;
    }

}
