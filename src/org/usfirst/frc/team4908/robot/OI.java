package org.usfirst.frc.team4908.robot;

import org.usfirst.frc.team4908.robot.commands.GrabGamePieceAction;
import org.usfirst.frc.team4908.robot.commands.PositionElevatorCommand;
import org.usfirst.frc.team4908.robot.commands.ZeroElevatorCommand;
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
		RIGHT_STICK.setButton(1, new PositionElevatorCommand(500), ButtonState.PRESSED);
		RIGHT_STICK.setButton(2, new ZeroElevatorCommand(0.3), ButtonState.PRESSED);
		
		RIGHT_STICK.setButton(3, new PositionElevatorCommand(600), ButtonState.PRESSED);
		RIGHT_STICK.setButton(4, new GrabGamePieceAction(), ButtonState.PRESSED);		
	}
}

