/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acsrobotics.deerbruhh.subsystems;

import com.acsrobotics.deerbruhh.RobotMap;
import com.acsrobotics.deerbruhh.commands.ScissorStop;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Alessio
 */
public class ScissorLift extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Victor scissorMotor;
    DigitalInput limitScissor;
    Counter counter;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ScissorStop());
    }
    
    public ScissorLift(){
        scissorMotor = new Victor(RobotMap.scissorLiftMotor);
        limitScissor = new DigitalInput(RobotMap.sScissorLift);
        counter = new Counter(limitScissor);
    }
    
    public boolean isSwitchSet(){
        return counter.get() > 0;
    }
    
    public void initializeCounter(){
        counter.reset();
    }
    
    public void ScissorUp(){
        scissorMotor.set(0.5);
    }
    
    public void ScissorDown(){
        scissorMotor.set(-0.5);
    }
    
    public void ScissorStop(){
        scissorMotor.set(0.0);
    }
}
