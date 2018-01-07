/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author tuvshuu
 */
@ManagedBean(name = "cardExpirationDate")
@SessionScoped
public class CreditCardExpiration implements Serializable {

    private int month = 1;
    private int year = 2010;

    public int getMonth() {
        return month;
    }

    public void setMonth(int newValue) {
        month = newValue;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int newValue) {
        year = newValue;
    }

}
