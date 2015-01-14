package org.usfirst.frc.team4908.robot.misc;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class SmartButton extends JoystickButton {
	
	private int buttonNumber;

	public SmartButton(GenericHID joystick, int buttonNumber) {
		super(joystick, buttonNumber);
		this.buttonNumber = buttonNumber;
	}
	
	public int getButtonIndex() {
		return buttonNumber;
	}
}
