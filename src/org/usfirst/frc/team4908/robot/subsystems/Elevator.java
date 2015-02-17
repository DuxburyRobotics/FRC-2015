package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.commands.ControlElevatorCommand;
import org.usfirst.frc.team4908.robot.misc.Constants;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Elevator extends PIDSubsystem {
	
	private final VictorSP elevatorDriveMotor1;
	private final VictorSP elevatorDriveMotor2;
	public final Encoder elevatorEncoder;	//TODO: Make private when done testing
	private final DigitalInput bottomLimitSwitch;
	private final DigitalInput topLimitSwitch;
	private int desiredPosition;
	private boolean overridden;
	
	public Elevator() {
		super("Elevator", 0.005, 0.0001, 0.0001);
		
		setAbsoluteTolerance(Constants.ELEVATOR_ABSOLUTE_TOLERANCE);
		setOutputRange(-1.0, 1.0);
		
		elevatorDriveMotor1 = new VictorSP(Constants.ELEVATOR_DRIVE_LMOTOR_PORT);
		elevatorDriveMotor2 = new VictorSP(Constants.ELEVATOR_DRIVE_RMOTOR_PORT);
		
		elevatorEncoder = new Encoder(Constants.ELEVATOR_ENCODER_A_PORT, Constants.ELEVATOR_ENCODER_B_PORT, false, Encoder.EncodingType.k4X);
		
		bottomLimitSwitch = new DigitalInput(Constants.ELEVATOR_BOTTOM_LIMIT_PORT);
		topLimitSwitch = new DigitalInput(Constants.ELEVATOR_TOP_LIMIT_PORT);
		
		desiredPosition = 0;
		
		overridden = false;	//TODO: Do this
		
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
	
	public boolean isMaxedOut() {
		return !topLimitSwitch.get();
	}
	
	public boolean isOverridden() {
		return overridden;
	}
	
	public void setDesiredPosition(int desiredPosition) {
		setSetpoint(desiredPosition);
		this.desiredPosition = desiredPosition;
	}
	
	public int getDesiredPosition() {
		return desiredPosition;
	}
	
	public void override() {
		overridden = true;
	}
	
	public void returnIncrementalControl() {
		overridden = false;
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ControlElevatorCommand());
	}
}
