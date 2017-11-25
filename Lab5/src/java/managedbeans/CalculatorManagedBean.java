/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author tuvshuu
 */
@ManagedBean(name = "calculatorBean")
@RequestScoped
public class CalculatorManagedBean {

    private Double firstNumber;
    private Double secondNumber;
    private Double result;

    public Double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(Double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public Double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(Double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public String add() {
        this.result = this.firstNumber + this.secondNumber;
        return "index";
    }

    public String subtract() {
        this.result = this.firstNumber - this.secondNumber;
        return "index";
    }

    public String multiply() {
        this.result = this.firstNumber * this.secondNumber;
        return "index";
    }

    public String divide() {
        this.result = this.firstNumber / this.secondNumber;
        return "index";
    }
}
