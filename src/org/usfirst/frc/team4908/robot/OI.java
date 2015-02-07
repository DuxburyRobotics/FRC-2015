package org.usfirst.frc.team4908.robot;

import org.usfirst.frc.team4908.robot.commands.PIDTestCommand;
import org.usfirst.frc.team4908.robot.misc.Constants;
import org.usfirst.frc.team4908.robot.misc.FullJoystick;
import org.usfirst.frc.team4908.robot.misc.FullJoystick.ButtonState;

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
		
		mapButtons();
	}
	
	public void mapButtons() {
//		RIGHT_STICK.setButton(1, new RaiseElevatorCommand(), ButtonState.PRESSED);
//		RIGHT_STICK.setButton(2, new LowerElevatorCommand(), ButtonState.PRESSED);
//		RIGHT_STICK.setButton(1, new StopElevatorCommand(), ButtonState.RELEASED);
//		RIGHT_STICK.setButton(2, new StopElevatorCommand(), ButtonState.RELEASED);
		
		RIGHT_STICK.setButton(1, new PIDTestCommand(800), ButtonState.PRESSED);
		RIGHT_STICK.setButton(2, new PIDTestCommand(0.0), ButtonState.PRESSED);
	}
}

