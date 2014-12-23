/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// REVAMP PLEASE //

/*package com.acsrobotics.deerbruhh.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.acsrobotics.deerbruhh.RobotMap;


public class Pneumatics extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
        Compressor mainCompressor;
        Solenoid leftPiston;
        Solenoid rightPiston;
    public Pneumatics(){
        //mainCompressor = new Compressor(RobotMap.compressor,RobotMap.compressorRelay);
        //leftPiston = new Solenoid(RobotMap.leftPiston);
        rightPiston = new Solenoid(RobotMap.rightMotor);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void compressorOn(){
        mainCompressor.start();
    }
    public void compressorOff(){
        mainCompressor.stop();
    }
}
*/