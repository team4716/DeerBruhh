/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acsrobotics.deerbruhh.commands;

/**
 *
 * @author Alessio
 */
public class DriveForward extends CommandBase {
    
    public DriveForward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drivetrain);
        this.setTimeout(2.3);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Moving Forward (auto)");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drivetrain.moveForward();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
