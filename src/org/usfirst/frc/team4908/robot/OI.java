package org.usfirst.frc.team4908.robot;

import org.usfirst.frc.team4908.robot.misc.Constants;
import org.usfirst.frc.team4908.robot.misc.FullJoystick;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static FullJoystick RIGHT_STICK;
	public static FullJoystick LEFT_STICK;
	
	public OI() {
		RIGHT_STICK = new FullJoystick(new Joystick(Constants.JOYSTICK_RIGHT));
		LEFT_STICK = new FullJoystick(new Joystick(Constants.JOYSTICK_LEFT));
	}
}

