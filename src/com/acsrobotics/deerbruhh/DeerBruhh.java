/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.acsrobotics.deerbruhh;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import com.acsrobotics.deerbruhh.commands.CommandBase;
import com.acsrobotics.deerbruhh.commands.Autonomous;
import com.acsrobotics.deerbruhh.commands.Autonomous2;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 * 
 * <p>This is the main robot class for an robot that is designed to deliver sodas.
 * It is designed to be able to both handle delivering soda autonomously and
 * under operator control using a joystick. The goal is that this is to provide
 * an example of a more complicated command based robot.</p>
 * 
 * <p> In is recommended that you have read at least the beginning of the
 * cookbook and are familiar with the basics of command base programming before
 * you start trying to understand this example. When reading through this, the
 * recommended order is:</p>
 * <ol>
 * <li>{@link RobotMap}</li>
 * <li>The subsystems starting with {@link Claw}</li>
 * <li>{@link CommandBase}</li>
 * <li>The commands staring with {@link SodaDelivery}</li>
 * <li>{@link OI}</li>
 * </ol>
 * 
 * <p>The only modifications from the default file created are setting the
 * autonomousCommand to SodaDelivery in robotInit and a few calls to status 
 * functions in teleopPeriodic.</p>
 * 
 * <p>Recommended next step: {@link RobotMap}</p>
 * 
 * @author Alex Henning
 */
public class DeerBruhh extends IterativeRobot {

    Command autonomousCommand;
    SendableChooser autoChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // Initialize the CommandBase so that everything is ready to run
        CommandBase.init();
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Autonomous 1", new Autonomous());
        autoChooser.addObject("Autonomous 2", new Autonomous2());
        SmartDashboard.putData(Scheduler.getInstance());
        SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
        
        // instantiate the command used for the autonomous period
        // Set it so that it runs the SodaDelivery command automatically during 
        // the automous period.
       
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        autonomousCommand = (Command) autoChooser.getSelected();
        autonomousCommand.start();
    }
    
    private String GetAutonomousName(){
        String name = SmartDashboard.getString("Autonomous Mode", "Basic Drive");
        return name;
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
       
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}
