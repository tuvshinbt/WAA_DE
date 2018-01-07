/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.IntegerConverter;

/**
 *
 * @author tuvshuu
 */
@FacesComponent("com.corejsf.Spinner")
public class UISpinner extends UIInput {

    private static final String MORE = ".more";
    private static final String LESS = ".less";

    private static Map<String, Integer> RANGE_VALUES = new HashMap<String, Integer>();
    private static final String MIN = "_MIN";
    private static final String MAX = "_MAX";

    public UISpinner() {
        setConverter(new IntegerConverter()); // to convert the submitted value
        setRendererType(null); // this component renders itself
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String clientId = getClientId(context);

        encodeInputField(writer, clientId);
        encodeDecrementButton(writer, clientId);
        encodeIncrementButton(writer, clientId);
    }

    @Override
    public void decode(FacesContext context) {
        Map<String, String> requestMap
                = context.getExternalContext().getRequestParameterMap();
        String clientId = getClientId(context);

        int increment;
        boolean checkNewRangeValue = false;
        if (requestMap.containsKey(clientId + MORE)) {
            increment = 1;
        } else if (requestMap.containsKey(clientId + LESS)) {
            increment = -1;
        } else {
            increment = 0;
            if (requestMap.containsKey("spinnerForm:next")) {
                checkNewRangeValue = true;
            }
        }

        try {
            int submittedValue
                    = Integer.parseInt((String) requestMap.get(clientId));
            System.out.println("checkNewRangeValue - " + checkNewRangeValue);
            if (checkNewRangeValue) {
                checkIfToRenewRangeValues(context, submittedValue);
            }
            int newValue = getIncrementedValue(submittedValue, increment);
            setSubmittedValue("" + newValue);
        } catch (NumberFormatException ex) {
            setSubmittedValue((String) requestMap.get(clientId));
        } catch (IOException ex) {
            Logger.getLogger(UISpinner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void encodeInputField(ResponseWriter writer, String clientId)
            throws IOException {
        writer.startElement("input", this);
        writer.writeAttribute("name", clientId, null);

        Object v = getValue();
        if (v != null) {
            writer.writeAttribute("value", v, "value");
        }

        Object size = getAttributes().get("size");
        if (size != null) {
            writer.writeAttribute("size", size, "size");
        }

        if (RANGE_VALUES.get(clientId + MIN) != null) {
            writer.writeAttribute("minimum", RANGE_VALUES.get(clientId + MIN), "minimum");
        }
        if (RANGE_VALUES.get(clientId + MAX) != null) {
            writer.writeAttribute("maximum", RANGE_VALUES.get(clientId + MAX), "maximum");
        }

        writer.endElement("input");
    }

    private void encodeDecrementButton(ResponseWriter writer, String clientId)
            throws IOException {
        writer.startElement("input", this);
        writer.writeAttribute("type", "submit", null);
        writer.writeAttribute("name", clientId + LESS, null);
        writer.writeAttribute("value", "<", "value");
        writer.endElement("input");
    }

    private void encodeIncrementButton(ResponseWriter writer, String clientId)
            throws IOException {
        writer.startElement("input", this);
        writer.writeAttribute("type", "submit", null);
        writer.writeAttribute("name", clientId + MORE, null);
        writer.writeAttribute("value", ">", "value");
        writer.endElement("input");
    }

    private void checkIfToRenewRangeValues(FacesContext context, int submittedValue) throws IOException {
        String clientId = getClientId(context);
        Integer minimum = toInteger(getAttributes().get("minimum"));
        Integer maximum = toInteger(getAttributes().get("maximum"));
        if (minimum > submittedValue) {
            // To set new minimum value
            RANGE_VALUES.put(clientId + MIN, submittedValue);
        } else if (maximum < submittedValue) {
            // To set new maximum value
            RANGE_VALUES.put(clientId + MAX, submittedValue);
        }
    }

    private int getIncrementedValue(int submittedValue, int increment) {
        Integer minimum = toInteger(getAttributes().get("minimum"));
        Integer maximum = toInteger(getAttributes().get("maximum"));
        int newValue = submittedValue + increment;

        if ((minimum == null || newValue >= minimum.intValue())
                && (maximum == null || newValue <= maximum.intValue())) {
            return newValue;
        } else {
            return submittedValue;
        }
    }

    private static Integer toInteger(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        if (value instanceof String) {
            return Integer.parseInt((String) value);
        }
        throw new IllegalArgumentException("Cannot convert " + value);
    }
}
