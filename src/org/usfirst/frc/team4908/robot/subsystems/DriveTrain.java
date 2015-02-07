package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.commands.DriveCommand;
import org.usfirst.frc.team4908.robot.misc.Constants;
import org.usfirst.frc.team4908.robot.misc.DragonDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	private final DragonDrive dragonDrive;
	private final VictorSP leftDriveMotor;
	private final VictorSP rightDriveMotor;
	
	public DriveTrain() {
		leftDriveMotor = new VictorSP(Constants.LEFT_MOTOR_PORT);
		rightDriveMotor = new VictorSP(Constants.RIGHT_MOTOR_PORT);
		
		dragonDrive = new DragonDrive(leftDriveMotor, rightDriveMotor);
		dragonDrive.setMaxOutput(Constants.DRIVE_MAX_POWER);
		dragonDrive.setSensitivity(Constants.DRIVE_SENSITIVITY);
	}
	
	public void driveTeleop(Joystick joystick) {
		dragonDrive.arcadeTwistDrive(joystick);
	}
	
	public void stopDriving() {
		dragonDrive.setLeftRightMotorOutputs(0.0, 0.0);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DriveCommand());
	}
}
