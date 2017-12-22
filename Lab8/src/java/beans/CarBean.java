/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author tuvshuu
 */
@ManagedBean(name = "car")
@RequestScoped
public class CarBean implements Serializable {

    private static final long serialVersionUID = 1L;

    Brand brand = new Brand("");
    Licence licence = new Licence("");
    Double price;

    public CarBean() {
    }

    public String result() {
        return "validationResult";
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Licence getLicence() {
        return licence;
    }

    public void setLicence(Licence licence) {
        this.licence = licence;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
