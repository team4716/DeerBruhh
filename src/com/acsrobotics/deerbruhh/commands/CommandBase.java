package com.acsrobotics.deerbruhh.commands;

/* Robot Imports */
import com.acsrobotics.deerbruhh.OI;
import com.acsrobotics.deerbruhh.RobotMap;
import com.acsrobotics.deerbruhh.subsystems.DriveTrain;
import com.acsrobotics.deerbruhh.subsystems.Loader;
import com.acsrobotics.deerbruhh.subsystems.ScissorLift;
//import com.acsrobotics.deerbruhh.subsystems.Pneumatics;
/* ------ END ------ */

/* WPILib Imports */
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Compressor;
/* ------ END ------ */

public abstract class CommandBase extends Command {
    
    /* Has to have this */
    public static OI oi;
    /* ------ END ------ */
    
    private static Compressor compressor; // Calls Compressor Object
    
    /* Subsystems Required */
    public static DriveTrain drivetrain = new DriveTrain();
    public static Loader loader = new Loader();
    public static ScissorLift scissorlift = new ScissorLift();
    //public static Pneumatics pneumatics = new Pneumatics();

   /* Initialize CommandBase */
    public static void init() {
        oi = new OI();
        
        // Optional: Logs the currently running command for each subsystem in
        //           the SmartDashboard. This can be useful for debugging.
        
        /* SmartDashboard Subsystem Data */
        SmartDashboard.putData(drivetrain);
        SmartDashboard.putData(loader);
        SmartDashboard.putData(scissorlift);
        /* ------ END ------ */
        
        /* LiveWindow Data (Only Works in Test Mode) */
        drivetrain.addInLiveWindow();
        /* ------ END ------ */
        
        /* Compressor */
        compressor = new Compressor(RobotMap.compressor, RobotMap.compressorRelay);
        compressor.start();
        /* ------ END ------ */

    }
    
    /* Automatically Created Constructors */
    public CommandBase(String name) { super(name); }
    public CommandBase() { super(); }
}
