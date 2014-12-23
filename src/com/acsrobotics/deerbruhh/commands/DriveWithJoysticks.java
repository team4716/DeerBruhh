package com.acsrobotics.deerbruhh.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveWithJoysticks extends CommandBase {

    public DriveWithJoysticks() {
        requires(drivetrain);
        
    }

    protected void initialize() {
        System.out.println("Totally supposed to move");
    }


    protected void execute() {
        drivetrain.arcadeDrive(
                oi.getStickY(),
                -oi.getStickX());
        SmartDashboard.putNumber("Y Axis", oi.getStickY());
        SmartDashboard.putNumber("X Axis", oi.getStickX());
        SmartDashboard.putNumber("Robot Speed", Math.abs(oi.getStickY()));
    }

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
