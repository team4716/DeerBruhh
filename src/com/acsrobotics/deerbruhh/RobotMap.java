package com.acsrobotics.deerbruhh;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * <p>One of the benefits of the RobotMap is you can write your code without 
 * knowing the ports in advance and can easily check that everything is wired
 * properly from one simple file. Additionally, there are less magic numbers
 * floating around the code so it is easier to understand and debug.</p>
 * 
 * <p>Recommended next step: {@link Claw}</p>
 * 
 * @author Alex Henning
 */
public class RobotMap {
    // Motors: This is the mapping of motors ports marked PWM on the DIO board
    public static final int
            leftMotor = 1,
            rightMotor = 2,
            leftIntakeMotor = 3,
            rightIntakeMotor = 4,
            scissorLiftMotor = 5,
            shooterMotor = 6;
       
    // Sensors: This is the mapping of the analog ports on the analog module
    // to the relevant sensors.
    public static final int
            compressor = 1;
            //sScissorLift = 2,
            //sLauncher = 3;
    
    public static final int
            compressorRelay = 1,
            leftPiston = 2,
            rightPiston = 3;
           
    
    // Additional mappings could be included, but are not used on this robot for
    // the task of soda delivery.
}
