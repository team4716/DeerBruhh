package com.acsrobotics.deerbruhh;

import com.acsrobotics.deerbruhh.commands.Autonomous;
import com.acsrobotics.deerbruhh.commands.Autonomous2;
import com.acsrobotics.deerbruhh.commands.LoaderRelease;
import com.acsrobotics.deerbruhh.commands.LoaderIntake;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * <p>The operator interface class ties the commands that have been implemented
 * to the physical controls of the user. This allows you to bind the same
 * command that executes autonomous to a button. It also reveal the joystick as
 * used by the DriveWithJoysticks command.</p>
 * 
 * @author Alex Henning
 */
public class OI {
    // Create the joystick and of the 8 buttons on it
    Joystick leftJoy = new Joystick(1);
    Button button1 = new JoystickButton(leftJoy, 1),
            button2 = new JoystickButton(leftJoy, 2),
            button3 = new JoystickButton(leftJoy, 3),
            button4 = new JoystickButton(leftJoy, 4),
            button5 = new JoystickButton(leftJoy, 5),
            button6 = new JoystickButton(leftJoy, 6),
            button7 = new JoystickButton(leftJoy, 7),
            button8 = new JoystickButton(leftJoy, 8);
    Joystick rightJoy = new Joystick(2);
    Button rbutton1 = new JoystickButton(rightJoy, 1),
            rbutton2 = new JoystickButton(rightJoy, 2),
            rbutton3 = new JoystickButton(rightJoy, 3),
            rbutton4 = new JoystickButton(rightJoy, 4),
            rbutton5 = new JoystickButton(rightJoy, 5),
            rbutton6 = new JoystickButton(rightJoy, 6),
            rbutton7 = new JoystickButton(rightJoy, 7),
            rbutton8 = new JoystickButton(rightJoy, 8);
    
    
            

    /**
     * Bind the press of each button to a specific command or command group.
     */
    public OI() {
        
        rbutton2.whileHeld(new LoaderIntake());
        rbutton3.whileHeld(new LoaderRelease());
        
        //Test Commands off the SmartDashboard
        SmartDashboard.putData("Intake", new LoaderIntake());
        SmartDashboard.putData("Release", new LoaderRelease());
        SmartDashboard.putData("Autonomous 1", new Autonomous());
        SmartDashboard.putData("Autonomous 2", new Autonomous2());
        
    }
    
    /**
     * @return The value of the left joystick.
     */
    public double getStickY() {
        return leftJoy.getY();
    }
    
    /**
     * @return The value of the right joystick. Note: this uses raw axis because
     *         we have a logitech joystick that resembles a PS controller.
     */
    public double getStickX() {
        return leftJoy.getX();
    }
}

