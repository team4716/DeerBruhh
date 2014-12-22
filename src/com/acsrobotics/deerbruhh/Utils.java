/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acsrobotics.deerbruhh;

/**
 *
 * @author Alessio
 */
public class Utils {
    
    private static final String CLEAR = "          ";
    
    public static double rampSpeed(double input) {
        //auto set sensitivity to .5
        return rampSpeed(input, .5);
    }
    
    public static double rampSpeed(double input, double sensitivity) {

        //if (IsInDeadband(input)) {
        //    return 0;
        //}

        //formula for ramping: f(x) = ax^3 + (1-a)x where a is the sensitivity and x is the input
        return (sensitivity * input * input * input + (1 - sensitivity) * input);
    }
}
