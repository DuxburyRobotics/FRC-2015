package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.commands.ArmControlCommand;
import org.usfirst.frc.team4908.robot.misc.Constants;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.VictorSP;

public class Intake extends Subsystem {

	private VictorSP leftArmMotor;
	private VictorSP rightArmMotor;
	
	public Intake() {
		super("Intake");
		leftArmMotor = new VictorSP(Constants.LEFT_ARM_MOTOR_PORT);
		rightArmMotor = new VictorSP(Constants.RIGHT_ARM_MOTOR_PORT);
	}
	
	public void rollIntakeWheels(double power) {
		leftArmMotor.set(-power);
		rightArmMotor.set(power);
	}
	
	public void stopArmMotors() {
		leftArmMotor.set(0.0);
		rightArmMotor.set(0.0);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArmControlCommand());
	}
}
