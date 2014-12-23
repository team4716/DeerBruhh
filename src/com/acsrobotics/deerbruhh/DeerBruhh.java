/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.acsrobotics.deerbruhh;

/* Robot Command Imports */

import com.acsrobotics.deerbruhh.commands.CommandBase;
import com.acsrobotics.deerbruhh.commands.Autonomous;
import com.acsrobotics.deerbruhh.commands.Autonomous2;

/* ------ END ------ */

/* WPILib Imports */

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/* ------ END ------ */


public class DeerBruhh extends IterativeRobot {

    /* Object Declaration */
    
    Command autonomousCommand;
    SendableChooser autoChooser;
    
    /* ------ END ------ */

    /* When Robot Boots Up, Any Mode */
    public void robotInit() {
        
        CommandBase.init(); // Check later, can possibly combine the two.
        
        /* Multiple Autonomous Mode Select */
        
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Autonomous 1", new Autonomous());
        autoChooser.addObject("Autonomous 2", new Autonomous2());
        SmartDashboard.putData(Scheduler.getInstance());
        SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
        
        /* ------ END ------ */
       
    }

    public void autonomousInit() {
        //Defines the Command that is Chosen via Smart Dashboard
        autonomousCommand = (Command) autoChooser.getSelected();
        
        autonomousCommand.start();
    }
    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
       
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}
