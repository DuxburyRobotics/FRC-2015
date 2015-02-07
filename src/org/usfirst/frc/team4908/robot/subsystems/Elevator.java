package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.misc.Constants;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Elevator extends PIDSubsystem {
	
	//TODO: We need two limit switches at either end of the lift to zero out the encoders

	private final VictorSP elevatorDriveMotor1;
	private final VictorSP elevatorDriveMotor2;
	public final Encoder elevatorEncoder;	//TODO: Make private when done testing
	
	public Elevator() {
		super("Elevator", 0.025, 0.025, 0.025);		//TODO: Tweak these values
		
		elevatorDriveMotor1 = new VictorSP(Constants.ELEVATOR_DRIVE_LMOTOR_PORT);
		elevatorDriveMotor2 = new VictorSP(Constants.ELEVATOR_DRIVE_RMOTOR_PORT);
		
		elevatorEncoder = new Encoder(Constants.ENCODER_A, Constants.ENCODER_B, false, Encoder.EncodingType.k4X);
		elevatorEncoder.reset();
		
		setPercentTolerance(5.0);	//TODO: Tweak this value
	}
	
	public void resetElevator() {
		elevatorEncoder.reset();
	}

	@Override
	protected double returnPIDInput() {
		return elevatorEncoder.getDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		elevatorDriveMotor1.pidWrite(-output*0.5);
		elevatorDriveMotor2.pidWrite(-output*0.5);
	}
	
	public void stopElevator() {
		elevatorDriveMotor1.set(0.0);
		elevatorDriveMotor2.set(0.0);
	}

	@Override
	protected void initDefaultCommand() { }
}
