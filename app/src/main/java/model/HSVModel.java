package model;

import java.util.Observable;

import android.graphics.Color;

public class HSVModel extends Observable {

    // CLASS VARIABLES
    public static final int MAX_HUE   = 359;
    public static final int MAX_SAT = 100;
    public static final int MAX_VAL   = 100;
    public static final int MIN_HSV   = 0;

    // INSTANCE VARIABLES
    private float hue;
    private float saturation;
    private float value;

//  No argument constructor.

    public HSVModel()
    {
        this.hue   = MAX_HUE;
        this.saturation   = MAX_SAT;
        this.value   = MAX_VAL;
    }

    public void asBlack() { this.setHSV( 0,0,0 ); }
    public void asRed() { this.setHSV( 0,100,100 ); }
    public void asLime() { this.setHSV( 120,100,100 ); }
    public void asBlue() { this.setHSV( 240,100,100 ); }
    public void asYellow() { this.setHSV( 60,100,100 ); }
    public void asCyan() { this.setHSV( 180,100,100 ); }
    public void asMagenta() { this.setHSV( 300,100,100 ); }
    public void asSilver() { this.setHSV( 0,0,75 ); }
    public void asGray() { this.setHSV( 0,0,50 ); }
    public void asMaroon() { this.setHSV( 0,100,50 ); }
    public void asOlive() { this.setHSV( 60,100,50 ); }
    public void asGreen() { this.setHSV( 120,100,50 ); }
    public void asPurple() { this.setHSV( 300,100,50 ); }
    public void asTeal() { this.setHSV( 180,100,50 ); }
    public void asNavy() { this.setHSV( 240,100,50 ); }


    // GETTERS -- do not touch
    public float getHue()
    {
        return hue;
    }

    public float getSaturation()
    {
        return saturation;
    }

    public float getValue()
    {
        return value;
    }

    // SETTERS - do not touch
    public void setHue( float hue )
    {
        this.hue = hue;
        this.updateObservers();
    }

    public void setSaturation(float saturation)
    {
        this.saturation = saturation;
        this.updateObservers();
    }

    public void setValue(float value)
    {
        this.value = value;
        this.updateObservers();
    }

    // Convenient setter
    public void setHSV(float hue, float saturation, float value)
    {
        this.hue   = hue;
        this.saturation = saturation;
        this.value = value;
        this.updateObservers();
    }

    // the model has changed!
    // broadcast the update method to all registered observers
    private void updateObservers()
    {
        this.setChanged();
        this.notifyObservers();
    }

}