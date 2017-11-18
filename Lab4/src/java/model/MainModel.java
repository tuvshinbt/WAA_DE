/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @author tuvshuu
 */
public class MainModel {

    private HashMap<String, Person> personMap = null;

    public MainModel(HashMap personMap) {
        this.personMap = personMap;
    }

    public HashMap<String, Person> getPersonMap() {
        return personMap;
    }

    public void setPersonMap(HashMap<String, Person> personMap) {
        this.personMap = personMap;
    }

    public void addPerson(String key, Person person) {
        this.personMap.put(key, person);
    }

    public void removePerson(String key) {
        this.personMap.remove(key);
    }

}
