package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.misc.Constants;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Elevator extends PIDSubsystem {

	private VictorSP elevatorDrive1;
	private VictorSP elevatorDrive2;
	private final Encoder elevatorTracker;
	
	public Elevator() {
		super("Elevator", 0.2, 0.0, 0.0);
		elevatorDrive1 = new VictorSP(Constants.ELEVATOR_DRIVE_LMOTOR_PORT);
		elevatorDrive2 = new VictorSP(Constants.ELEVATOR_DRIVE_RMOTOR_PORT);
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
		elevatorDrive1.pidWrite(output);
		elevatorDrive2.pidWrite(output);
	}
	
	public void killElevator() {
		elevatorDrive1.set(0.0);
		elevatorDrive2.set(0.0);
	}

	@Override
	protected void initDefaultCommand() { }
}
