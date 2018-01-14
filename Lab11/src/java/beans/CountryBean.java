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
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author tuvshuu
 */
@ManagedBean
@RequestScoped
public class CountryBean {

    private String name = "";
    private static List<String> coutries;

    static {
        coutries = Arrays.asList("Hi", "Hello", "World");
    }

    /**
     * Creates a new instance of CountryBean
     */
    public CountryBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getCountries() {
        List<String> tempList = coutries.stream().filter(n -> n.toLowerCase().startsWith(this.name.toLowerCase())).collect(Collectors.toList());
        return tempList;
    }

}
