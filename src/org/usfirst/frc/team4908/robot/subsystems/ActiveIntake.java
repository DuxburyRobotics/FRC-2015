package org.usfirst.frc.team4908.robot.subsystems;

import org.usfirst.frc.team4908.robot.commands.intake.IntakeControlCommand;
import org.usfirst.frc.team4908.robot.misc.Constants;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.VictorSP;

public class ActiveIntake extends Subsystem {

	private final VictorSP leftArmMotor;
	private final VictorSP rightArmMotor;
	
	public ActiveIntake() {
		super("Active Intake");
		
		leftArmMotor = new VictorSP(Constants.LEFT_INTAKE_MOTOR_PORT);
		rightArmMotor = new VictorSP(Constants.RIGHT_INTAKE_MOTOR_PORT);
	}
	
	public void setIntakePower(double power) {
		leftArmMotor.set(-power);
		rightArmMotor.set(power);
	}
	
	public void stopIntakeMotors() {
		leftArmMotor.set(0.0);
		rightArmMotor.set(0.0);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new IntakeControlCommand());
	}
}
