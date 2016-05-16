package com.smile.gilberto.listviewcheckbox;

/**
 * Created by Registered User on 4/28/16.
 */
public class Country {

    //String code = null;
    String name = null;
    boolean selected = false;

    public Country( String name, boolean selected) {
        super();
        //this.code = code;
        this.name = name;
        this.selected = selected;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}