/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import beans.Licence;
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
@FacesValidator("utils.CarLicenceValidator")
public class CarLicenceValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        if (o == null) {
            return;
        }
        String licence;
        System.out.println("licence validate - " + o.toString());
        if (o instanceof Licence) {
            licence = o.toString();
        } else {
            System.out.println("ELSE");
            licence = o.toString();
        }
        if (!licence.matches("^[A-Z]{2}-\\d{2}-[A-Z]{2}$")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Licence plate is not valid!", "Invalid input!");
            throw new ValidatorException(message);
        }
    }

}
