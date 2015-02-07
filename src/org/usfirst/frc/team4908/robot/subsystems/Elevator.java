package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.commands.PIDTestCommand;
import org.usfirst.frc.team4908.robot.misc.Constants;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Elevator extends PIDSubsystem {
	
	//TODO: We need two limit switches at either end of the lift to zero out the encoders

	private VictorSP elevatorDriveMotor1;
	private VictorSP elevatorDriveMotor2;
	public Encoder elevatorEncoder;
	
	public Elevator() {
		super("Elevator", 0.025, 0.025, 0.025);
		
		elevatorDriveMotor1 = new VictorSP(Constants.ELEVATOR_DRIVE_LMOTOR_PORT);
		elevatorDriveMotor2 = new VictorSP(Constants.ELEVATOR_DRIVE_RMOTOR_PORT);
		
		elevatorEncoder = new Encoder(Constants.ENCODER_A, Constants.ENCODER_B, false);
				//,
				//Encoder.EncodingType.k4X);
		
		elevatorEncoder.reset();
		
		this.setPercentTolerance(5.0);
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
	
	public void killElevator() {
		elevatorDriveMotor1.set(0.0);
		elevatorDriveMotor2.set(0.0);
	}

	@Override
	protected void initDefaultCommand() { }
}
