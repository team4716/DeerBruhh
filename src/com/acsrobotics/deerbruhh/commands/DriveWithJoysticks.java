package com.acsrobotics.deerbruhh.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * <p>The default command for the drive train. When no other command is running,
 * the robot can be driven using the joysticks.</p>
 * 
 * <p>Recommended next step: {@link DriveToDistance}
 *
 * @author Alex Henning
 */
public class DriveWithJoysticks extends CommandBase {
    /**
     * Requires the drive train
     */
    public DriveWithJoysticks() {
        requires(drivetrain);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Totally supposed to move");
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Have the drivetrain drive tank drive with the latest values from joysticks.
     */
    protected void execute() {
        drivetrain.arcadeDrive(
                oi.getStickY(),
                oi.getStickX());
        SmartDashboard.getNumber("Y Axis", oi.getStickY());
        SmartDashboard.getNumber("X Axis", oi.getStickX());
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * @return false, so that it executes forever or until another command
     *         interrupts it.
     */
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