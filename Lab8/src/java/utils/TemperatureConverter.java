/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import beans.Temperature;
import beans.WeatherBean;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author tuvshuu
 */
//@FacesConverter(forClass = WeatherBean.class)
@FacesConverter("utils.TempConverter")
public class TemperatureConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        System.out.println("GetAsObject " + string);
        boolean failedConversion = false;
        char invalidChar = '\0';
        Temperature resultBean = null;
        
        
        if (string.length() > 0 && (string.toLowerCase().charAt(0) == 'c' || string.toLowerCase().charAt(0) == 'f')) {
            try {
                resultBean = new Temperature(string);
            } catch (NumberFormatException e) {
                failedConversion = true;
                resultBean = null;
            }
        } else {
            if (string.length() > 0) {
                invalidChar = string.charAt(0);
            }
            failedConversion = true;
        }
        if (failedConversion) {
            FacesMessage message;
            if (invalidChar == '\0') {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid input!", "Invalid input!");
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid character! " + invalidChar, "Invalid character!");

            }
            throw new ConverterException(message);
        }
        return resultBean;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String value = o.toString();
        StringBuilder result = new StringBuilder(value.substring(1, value.length()));
        result.append(" ");
        result.append(value.toLowerCase().charAt(0) == 'c' ? "Celsius" : "Fahrenheit");
        System.out.println("result - " + result);
        return result.toString();
    }

    public static Locale getLocale(FacesContext context) {
        Locale locale = null;
        UIViewRoot viewRoot = context.getViewRoot();
        if (viewRoot != null) {
            locale = viewRoot.getLocale();
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return locale;
    }

    public static ClassLoader getClassLoader() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if (loader == null) {
            loader = ClassLoader.getSystemClassLoader();
        }
        return loader;
    }

}
