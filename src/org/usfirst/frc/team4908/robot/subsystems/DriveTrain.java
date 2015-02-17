package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.commands.drivetrain.DriveCommand;
import org.usfirst.frc.team4908.robot.misc.Constants;
import org.usfirst.frc.team4908.robot.misc.DragonDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	private final DragonDrive dragonDrive;
	private final VictorSP leftDriveMotor;
	private final VictorSP rightDriveMotor;
	private final Encoder leftEncoder;
	private final Encoder rightEncoder;
	
	public DriveTrain() {
		super("Drive Train");
		
		leftDriveMotor = new VictorSP(Constants.LEFT_MOTOR_PORT);
		rightDriveMotor = new VictorSP(Constants.RIGHT_MOTOR_PORT);
		
		dragonDrive = new DragonDrive(leftDriveMotor, rightDriveMotor);
		dragonDrive.setMaxOutput(Constants.DRIVE_MAX_POWER);
		dragonDrive.setSensitivity(Constants.DRIVE_SENSITIVITY);
		
		leftEncoder = new Encoder(
				Constants.DRIVE_ENCODER_LEFT_A_PORT,
				Constants.DRIVE_ENCODER_LEFT_B_PORT, 
				false, 
				Encoder.EncodingType.k4X);
		
		rightEncoder = new Encoder(
				Constants.DRIVE_ENCODER_RIGHT_A_PORT,
				Constants.DRIVE_ENCODER_RIGHT_B_PORT, 
				false, 
				Encoder.EncodingType.k4X);
	}
	
	public void driveTeleop(Joystick joystick) {
		dragonDrive.arcadeTwistDrive(joystick);
		//dragonDrive.negativeIntertiaDrive(joystick);
		
	}
	
	public void stopDriving() {
		dragonDrive.setLeftRightMotorOutputs(0.0, 0.0);
	}
	
	public int convertToPulses(float distance) {
		float revs = distance / (6.0f * (float)Math.PI);
		float pulses = revs * 1440.0f;
		return Math.round(pulses);
	}
	
	public void resetDriveEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	public Encoder getLeftEncoder() {
		return leftEncoder;
	}
	
	public Encoder getRightEncoder() {
		return rightEncoder;
	}
	
	public void setDrivePower(double pidValue) {
		dragonDrive.setLeftRightMotorOutputs(pidValue, pidValue);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DriveCommand());
	}
}
