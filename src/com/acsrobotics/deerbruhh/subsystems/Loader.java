/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acsrobotics.deerbruhh.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.acsrobotics.deerbruhh.RobotMap;
import com.acsrobotics.deerbruhh.commands.LoaderStop;

/**
 *
 * @author Alessio
 */
public class Loader extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    Victor leftMotor;
    Victor rightMotor;
    Compressor mainCompressor;
    
    
    public Loader(){
        super("Loader");
        leftMotor = new Victor(RobotMap.leftIntakeMotor);
        rightMotor = new Victor(RobotMap.rightIntakeMotor);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new LoaderStop());
    }
    
    public void intakeBall(){
        leftMotor.set(1.0);
        rightMotor.set(-1.0);
    }
    
    public void releaseBall(){
        leftMotor.set(-1.0);
        rightMotor.set(1.0);
    }
    
    public void loaderOff(){
        leftMotor.set(0);
        rightMotor.set(0);
    }
}
