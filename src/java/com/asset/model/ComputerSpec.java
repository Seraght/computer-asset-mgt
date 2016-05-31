package com.asset.model;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Seraght
 */
public class ComputerSpec {

    private Map properties;

    public ComputerSpec(Map properties) {
        if (properties == null) {
            this.properties = new HashMap();
        } else {
            this.properties = new HashMap(properties);
        }
    }

    public Object getProperty(String propertyName) {
        return properties.get(propertyName);
    }

    public Map getProperties() {
        return properties;
    }

    public String getModel() {
        return (String) properties.get("model");
    }

    public String getBrand() {
        return (String) properties.get("brand");
    }

    public String getDescription() {
        return (String) properties.get("description");
    }
    
    public String getDeleteDetail() {
        return (String) properties.get("deleteDetail");
    }

    public boolean matches(ComputerSpec otherSpec) {
        for (Iterator i = otherSpec.getProperties().keySet().iterator();
                i.hasNext();) {
            String propertyName = (String) i.next();
            if (!properties.get(propertyName).equals(
                    otherSpec.getProperty(propertyName))) {
                return false;
            }
        }
        return true;
    }
}
