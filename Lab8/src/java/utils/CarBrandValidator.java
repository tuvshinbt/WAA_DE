/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import beans.Brand;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author tuvshuu
 */
@FacesValidator("utils.CarBrandValidator")
public class CarBrandValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        if (o == null) {
            return;
        }
        String brand;
        System.out.println("brand validate - " + o.toString());
        if (o instanceof Brand) {
            brand = o.toString();
        } else {
            System.out.println("ELSE");
            brand = o.toString();
        }
        if (!brand.equalsIgnoreCase("Mercedes") && !brand.equalsIgnoreCase("BMW")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Brand!", "Invalid input!");
            throw new ValidatorException(message);
        }
    }

}
