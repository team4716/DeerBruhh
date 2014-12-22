/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acsrobotics.deerbruhh.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.acsrobotics.deerbruhh.OI;
import com.acsrobotics.deerbruhh.RobotMap;
import com.acsrobotics.deerbruhh.subsystems.DriveTrain;
import com.acsrobotics.deerbruhh.subsystems.Loader;
import com.acsrobotics.deerbruhh.subsystems.Pneumatics;
import edu.wpi.first.wpilibj.Compressor;


/**
 * <p>The CommandBase class is automatically generated when the project is created.
 * However, whenever you create a new subsystem, you must create a public static
 * reference to it in the CommandBase class. All commands (except for
 * CommandGroups) should be subclasses of CommandBase.</p>
 * 
 * <p>Recommended next step: {@link ClawDoNothing}</p>
 * 
 * @author Alex Henning
 */
public abstract class CommandBase extends Command {
    // CommandBase holds a static instance of OI
    public static OI oi;
    
    private static Compressor compressor;
    
    // Instances of each subsystem
    public static DriveTrain drivetrain = new DriveTrain();
    public static Loader loader = new Loader();
    public static Pneumatics pneumatics = new Pneumatics();

    /**
     * Call this command to properly finish initializing the CommandBase.
     * This call is automatically included in the default template.
     */
    public static void init() {
        oi = new OI();
        
        // Optional: Logs the currently running command for each subsystem in
        //           the SmartDashboard. This can be useful for debugging.
        
        //SmartDashboard
        SmartDashboard.putData(drivetrain);
        SmartDashboard.putData(loader);

        
        //Compressor
        compressor = new Compressor(RobotMap.compressor, RobotMap.compressorRelay);
        compressor.start();

    }
    
    // Automatically created constructors.
    public CommandBase(String name) { super(name); }
    public CommandBase() { super(); }
}
