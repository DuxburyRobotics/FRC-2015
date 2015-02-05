package org.usfirst.frc.team4908.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.VictorSP;

public class Intake extends Subsystem {

	private VictorSP leftArmMotor;
	private VictorSP rightArmMotor;
	
	@Override
	protected void initDefaultCommand() { }
	
	public void rollIntake(double power) {
		leftArmMotor.set(power);
		rightArmMotor.set(-power);
	}
	
	public void rollEject(double power) {
		leftArmMotor.set(-power);
		rightArmMotor.set(power);
	}
	
	public void stop() {
		leftArmMotor.set(0.0);
		rightArmMotor.set(0.0);
	}
}
