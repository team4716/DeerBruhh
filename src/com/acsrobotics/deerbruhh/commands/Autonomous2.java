package com.acsrobotics.deerbruhh.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Alessio
 */
public class Autonomous2 extends CommandGroup {
    
    public Autonomous2() {
        addSequential(new DriveForward());
        addSequential(new DriveRight());
        addSequential(new DriveRight());
    }
}
