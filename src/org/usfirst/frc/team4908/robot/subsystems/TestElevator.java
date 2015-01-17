package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.misc.Constants;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TestElevator extends Subsystem {

	private Victor motor;
	
	public TestElevator() {
		motor = new Victor(Constants.ELEVATOR_DRIVE_MOTOR_PORT);
	}
	
	public void setMotor(double val) {
		motor.set(val);
	}
	
	public void stopMotor() {
		motor.set(0.0);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}
