package com.acsrobotics.deerbruhh.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import com.acsrobotics.deerbruhh.RobotMap;
import com.acsrobotics.deerbruhh.commands.CommandBase;
import com.acsrobotics.deerbruhh.OI;
import com.acsrobotics.deerbruhh.Utils;
import com.acsrobotics.deerbruhh.commands.DriveWithJoysticks;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * <p>The drive train is PID subsystem, but unlike the {@link Wrist} and
 * {@link Elevator}, it is not always running PID. Instead, it can be run in a
 * manual tank drive or PID can be enabled and it will use a range finder to
 * drive a fixed distance away from the target.</p>
 * 
 * <p>Recommended next step: {@link CommandBase}</p>
 *
 * @author Alex Henning
 */
public class DriveTrain extends PIDSubsystem {
    // The constants for the P, I and D portion of PID
    private static final double Kp = 3;
    private static final double Ki = .2;
    private static final double Kd = 0.0;
    
    RobotDrive drive;
    AnalogChannel rangefinder;
    
    private Jaguar leftDrive;
    private Jaguar rightDrive;
    
    private int sensitivity = RobotMap.defaultSensitivity;


    // Initialize your subsystem here
    public DriveTrain() {
        super("DriveTrain", Kp, Ki, Kd);
        
        leftDrive = new Jaguar(RobotMap.leftMotor);
        rightDrive = new Jaguar(RobotMap.rightMotor);
        
        drive = new RobotDrive(leftDrive, rightDrive);
        
        drive.setSafetyEnabled(false);
        
        
        
    }
    
    /**
     * Set the default command to drive with joysticks.
     */
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoysticks());
    }

    /**
     * @return The value of the rangefinder used as the PID input device.
     *         These values correspond to your PID setpoint, in this case the
     *         value can be anywhere between 0v and 5v.
     */
    protected double returnPIDInput() {
        return rangefinder.getVoltage();
    }

    /**
     * @param output The value to set the output to as determined by the PID
     *               algorithm. This gets called each time through the PID loop
     *               to update the output to the motor.
     */
    protected void usePIDOutput(double output) {
        arcadeDrive(output, output);
    }
    
  
    public void arcadeDrive(double x, double y) {
        double xPow = Utils.rampSpeed(x, sensitivity/10);
        double yPow = Utils.rampSpeed(y, sensitivity/10);
        drive.arcadeDrive(xPow, yPow);
    }
    
    public void increaseSensitivity(){
        if(sensitivity < 10){
            sensitivity += 1;
        }
    }
    
    public void decreaseSensitivity(){
        if(sensitivity > 0){
            sensitivity -= 1;
        }
    }
    
    public void moveForward(){
        drive.drive(0.5, 0.0);
    }
    
    public void turnRight(){
        drive.drive(0.5, 0.5);
    }
    
    public void addInLiveWindow(){
        LiveWindow.addActuator(getName(), "Left Drive Motor", leftDrive);
        LiveWindow.addActuator(getName(), "Right Drive Motor", rightDrive);
    }
}

