package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.misc.Constants;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends PIDSubsystem {
	
	private Talon elevatorDrive;
	private final Encoder elevatorTracker;
	
	public Elevator() {
		super("Elevator", 0.0, 0.0, 0.0);
		elevatorDrive = new Talon(Constants.ELEVATOR_DRIVE_MOTOR_PORT);
		elevatorTracker = new Encoder(
				Constants.ENCODER_A, 
				Constants.ENCODER_B, 
				false,
				Encoder.EncodingType.k4X);
		elevatorTracker.reset();
	}

	@Override
	protected double returnPIDInput() {
		return elevatorTracker.getDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		elevatorDrive.pidWrite(output);
	}

	@Override
	protected void initDefaultCommand() {
		
	}
}
