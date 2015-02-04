package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.commands.DriveCommand;
import org.usfirst.frc.team4908.robot.misc.Constants;
import org.usfirst.frc.team4908.robot.misc.DragonDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	private final DragonDrive robotDrive;
	private final VictorSP leftMotor;
	private final VictorSP rightMotor;
	
	public DriveTrain() {
		leftMotor = new VictorSP(Constants.FRONT_LEFT_MOTOR_PORT);
		rightMotor = new VictorSP(Constants.FRONT_RIGHT_MOTOR_PORT);
		
		//frontLeftMotor = new Talon(Constants.FRONT_LEFT_MOTOR_PORT);
		//backLeftMotor = new Talon(Constants.BACK_LEFT_MOTOR_PORT);
		//frontRightMotor = new Talon(Constants.FRONT_RIGHT_MOTOR_PORT);
		//backRightMotor = new Talon(Constants.BACK_RIGHT_MOTOR_PORT);
		
		robotDrive = new DragonDrive(leftMotor, rightMotor);	//new DragonDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);
		robotDrive.setMaxOutput(Constants.DRIVE_MAX_POWER);
		robotDrive.setSensitivity(Constants.DRIVE_SENSITIVITY);
	}
	
	public void driveTeleop(final Joystick joystick) {
		robotDrive.arcadeTwistDrive(joystick);
		//negativeIntertiaDrive(joystick);//arca
	}
	
	public void stopDriving() {
		robotDrive.setLeftRightMotorOutputs(0.0, 0.0);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DriveCommand());
	}
}
