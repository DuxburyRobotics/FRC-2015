package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.misc.Constants;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TestElevator extends Subsystem {

	private VictorSP leftMotor;
	private VictorSP rightMotor;
	
	public TestElevator() {
		leftMotor = new VictorSP(Constants.ELEVATOR_DRIVE_LMOTOR_PORT);
		rightMotor = new VictorSP(Constants.ELEVATOR_DRIVE_RMOTOR_PORT);
	}
	
	public void setMotor(double val) {
		leftMotor.set(-val);
		rightMotor.set(-val);
	}
	
	public void stopMotor() {
		leftMotor.set(0.0);
		rightMotor.set(0.0);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}
