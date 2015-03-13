package org.usfirst.frc.team4908.robot;

import org.usfirst.frc.team4908.robot.commands.GrabGamePieceAction;
import org.usfirst.frc.team4908.robot.commands.elevator.MaxElevatorCommand;
import org.usfirst.frc.team4908.robot.commands.elevator.ZeroElevatorCommand;
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
		RIGHT_STICK = new FullJoystick(new Joystick(Constants.JOYSTICK_RIGHT_INDEX));
		LEFT_STICK = new FullJoystick(new Joystick(Constants.JOYSTICK_LEFT_INDEX));
		
		mapButtons();
	}
	
	public void mapButtons() {
		LEFT_STICK.setButton(1, new GrabGamePieceAction(), ButtonState.PRESSED);		//Grab a tote
		LEFT_STICK.setButton(2, new ZeroElevatorCommand(0.4), ButtonState.PRESSED);		//Lower elevator to zero position
		LEFT_STICK.setButton(3, new MaxElevatorCommand(0.4), ButtonState.PRESSED);		//Raise to maximum height
				
		//RIGHT_STICK.setButton(1, new CalibrateElevatorCommand(), ButtonState.PRESSED);
		
		//LEFT_STICK.setButton(6, command, ButtonState.TOGGLE_PRESSED);
	}
}