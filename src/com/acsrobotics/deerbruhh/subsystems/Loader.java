/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acsrobotics.deerbruhh.subsystems;


import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.acsrobotics.deerbruhh.RobotMap;
import com.acsrobotics.deerbruhh.commands.LoaderStop;
import com.acsrobotics.HelperClasses.PneumaticHelper;

/**
 *
 * @author Alessio
 */
public class Loader extends Subsystem {

    Victor leftMotor;
    Victor rightMotor;
    
    PneumaticHelper leftPiston;
    PneumaticHelper rightPiston;
    
    
    public Loader(){
        super("Loader");
        leftMotor = new Victor(RobotMap.leftIntakeMotor);
        rightMotor = new Victor(RobotMap.rightIntakeMotor);
        
        /* Check Once Tested on Robot */
        leftPiston = new PneumaticHelper(RobotMap.leftPistonPush, 
                                         RobotMap.leftPistonPull,
                                         RobotMap.leftPistonPull);
        
        rightPiston = new PneumaticHelper(RobotMap.rightPistonPush, 
                                          RobotMap.rightPistonPull, 
                                          RobotMap.rightPistonPull);
    }

    public void initDefaultCommand() {
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
    
    public void loaderExtend(){
        leftPiston.push();
        rightPiston.push();
    }
    
    public void loaderRetract(){
        leftPiston.pull();
        rightPiston.pull();
    }
    
      public boolean isLoaderExtended()
    {
        return !leftPiston.isPushed().booleanValue() && !rightPiston.isPushed().booleanValue();
    }
    
    public void setToDefaultPosition() {
        leftPiston.setToDefault();
        rightPiston.setToDefault();
    }
    
    public void zeroSolenoids() {
        leftPiston.reset();
        rightPiston.reset();
    }
}
