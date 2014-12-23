package com.acsrobotics.deerbruhh;

/**
 *
 * @author Alessio
 */
public class Utils {
    
    public static double rampSpeed(double input) {
        //auto set sensitivity to .5
        return rampSpeed(input, .5);
    }
    
    public static double rampSpeed(double input, double sensitivity) {

        //formula for ramping: f(x) = ax^3 + (1-a)x where a is the sensitivity and x is the input
        return (sensitivity * input * input * input + (1 - sensitivity) * input);
    }
}
