package com.acsrobotics.deerbruhh;

/* Robot Command Imports */
import com.acsrobotics.deerbruhh.commands.Autonomous;
import com.acsrobotics.deerbruhh.commands.Autonomous2;
import com.acsrobotics.deerbruhh.commands.LoaderRelease;
import com.acsrobotics.deerbruhh.commands.LoaderIntake;
import com.acsrobotics.deerbruhh.commands.LoaderPull;
import com.acsrobotics.deerbruhh.commands.LoaderPush;
/* ------ END ------ */

/* WPILib Imports */
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/* ------ END ------ */

/* Declaration Class of Joystick and the Assignation of Commands to Buttons */
/* With the addition of Joystick Axis properties -------------------------- */

public class OI {
    /* Drive Joystick Declaration and Button Realization */
    Joystick leftJoy = new Joystick(1);
    Button button1 = new JoystickButton(leftJoy, 1),
            button2 = new JoystickButton(leftJoy, 2),
            button3 = new JoystickButton(leftJoy, 3),
            button4 = new JoystickButton(leftJoy, 4),
            button5 = new JoystickButton(leftJoy, 5),
            button6 = new JoystickButton(leftJoy, 6),
            button7 = new JoystickButton(leftJoy, 7),
            button8 = new JoystickButton(leftJoy, 8);
    
    /* ------------------ END ------------------ */
    
    /* Controls Joystick Declaration and Button Realization */
    
    Joystick rightJoy = new Joystick(2);
    Button rbutton1 = new JoystickButton(rightJoy, 1),
            rbutton2 = new JoystickButton(rightJoy, 2),
            rbutton3 = new JoystickButton(rightJoy, 3),
            rbutton4 = new JoystickButton(rightJoy, 4),
            rbutton5 = new JoystickButton(rightJoy, 5),
            rbutton6 = new JoystickButton(rightJoy, 6),
            rbutton7 = new JoystickButton(rightJoy, 7),
            rbutton8 = new JoystickButton(rightJoy, 8);
    
    /* ------------------ END ------------------ */
    
    public OI() {
        
        /* Button Commands */
        
        rbutton2.whileHeld(new LoaderIntake());
        rbutton3.whileHeld(new LoaderRelease());
        
        rbutton6.whenPressed(new LoaderPush());
        rbutton7.whenPressed(new LoaderPull());
        
        /* ------------------ END ------------------ */
        
        /* Test Commands off the SmartDashboard */
        
        SmartDashboard.putData("Intake", new LoaderIntake());
        SmartDashboard.putData("Release", new LoaderRelease());
        SmartDashboard.putData("Extend Loader", new LoaderPush());
        SmartDashboard.putData("Retract Loader", new LoaderPull());
        SmartDashboard.putData("Autonomous 1", new Autonomous());
        SmartDashboard.putData("Autonomous 2", new Autonomous2());
        
 
        /* ------------------ END ------------------ */
        
    }
    
    /* Return Variables for Drive Joystick */
    
    public double getStickY() {
        return leftJoy.getY();
    }
    
    public double getStickX() {
        return leftJoy.getX();
    }
    /* ------------------ END ------------------ */
}

