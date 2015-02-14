package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.misc.Constants;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Elevator extends PIDSubsystem {
	
	//TODO: We need two limit switches at either end of the lift to zero out the encoders

	private final VictorSP elevatorDriveMotor1;
	private final VictorSP elevatorDriveMotor2;
	public final Encoder elevatorEncoder;	//TODO: Make private when done testing
	private final DigitalInput bottomLimitSwitch;
	private boolean overridden;
	
	public Elevator() {
		super("Elevator", 0.007, 0.0002, 0.0);		//TODO: Tweak these values
		
		this.setAbsoluteTolerance(5);
		setOutputRange(-1.0, 1.0);
		
		elevatorDriveMotor1 = new VictorSP(Constants.ELEVATOR_DRIVE_LMOTOR_PORT);
		elevatorDriveMotor2 = new VictorSP(Constants.ELEVATOR_DRIVE_RMOTOR_PORT);
		
		elevatorEncoder = new Encoder(Constants.ENCODER_A, Constants.ENCODER_B, false, Encoder.EncodingType.k4X);
		elevatorEncoder.setSamplesToAverage(10);
		
		bottomLimitSwitch = new DigitalInput(Constants.ELEVATOR_BOTTOM_LIMIT_PORT);
		
		overridden = false;
		
		resetElevator();
	}
	
	public void resetElevator() {
		elevatorEncoder.reset();
	}

	@Override
	protected double returnPIDInput() {
		return elevatorEncoder.get();
	}

	@Override
	protected void usePIDOutput(double output) {
		elevatorDriveMotor1.pidWrite(-output*Constants.ELEVATOR_DRIVE_MULTIPLIER);
		elevatorDriveMotor2.pidWrite(-output*Constants.ELEVATOR_DRIVE_MULTIPLIER);
	}
	
	public void setElevatorPower(double power) {
		elevatorDriveMotor1.set(power);
		elevatorDriveMotor2.set(power);
	}
	
	public void brakeElevator() {
		elevatorDriveMotor1.set(0.0);
		elevatorDriveMotor2.set(0.0);
	}
	
	public boolean isZeroed() {
		return !bottomLimitSwitch.get();
	}
	
	public boolean isOverridden() {
		return overridden;
	}
	
	public void override() {
		overridden = true;
	}
	
	public void returnIncrementalControl() {
		overridden = false;
	}

	@Override
	protected void initDefaultCommand() { }
}
