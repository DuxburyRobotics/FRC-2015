package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.misc.Constants;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	private final RobotDrive robotDrive;
	private final Talon frontLeftMotor;
	private final Talon backLeftMotor;
	private final Talon frontRightMotor;
	private final Talon backRightMotor;
	
	public DriveTrain() {
		frontLeftMotor = new Talon(Constants.FRONT_LEFT_MOTOR_PORT);
		backLeftMotor = new Talon(Constants.BACK_LEFT_MOTOR_PORT);
		frontRightMotor = new Talon(Constants.FRONT_RIGHT_MOTOR_PORT);
		backRightMotor = new Talon(Constants.BACK_RIGHT_MOTOR_PORT);
		
		robotDrive = new RobotDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);
	}
	
	public void driveTeleop(final Joystick joystick) {
		robotDrive.arcadeDrive(joystick);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}
