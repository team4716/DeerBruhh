/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acsrobotics.deerbruhh.commands;

import com.acsrobotics.deerbruhh.subsystems.ScissorLift;

/**
 *
 * @author Alessio
 */
public class ScissorStop extends CommandBase {
    
    public ScissorStop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(scissorlift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Scissor Lift Stopped");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        scissorlift.ScissorStop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
