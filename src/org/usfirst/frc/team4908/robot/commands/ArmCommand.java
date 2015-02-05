package org.usfirst.frc.team4908.robot.commands;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmCommand extends Command {
	
	private double power;
	
	public ArmCommand(double power) {
		super("Intake");
		this.power = power;
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {
		Robot.intake.rollIntake(power);
	}

	@Override
	protected void execute() { }

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.intake.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
