/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author tuvshuu
 */
@ManagedBean(name = "weather")
@RequestScoped
public class WeatherBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date date;
    private Temperature temperature;

    /**
     * Creates a new instance of weatherBean
     */
    public WeatherBean() {
    }

    public String result() {
        return "conversionResult";
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//    public String getTemperature() {
//        return temperature;
//    }
//
//    public void setTemperature(String temperature) {
//        this.temperature = temperature;
//    }
    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

}
