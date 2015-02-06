package org.usfirst.frc.team4908.robot.commands;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PIDTestCommand extends Command {

	private double position;
	
	public PIDTestCommand(double position) {
		super("PID Test");
		this.position = position;
		requires(Robot.elevator);
	}
	
	@Override
	protected void initialize() {
		Robot.elevator.setSetpoint(position);
	}

	@Override
	protected void execute() { }

	@Override
	protected boolean isFinished() {
		return false; //Robot.elevator.onTarget();
	}

	@Override
	protected void end() {
		Robot.elevator.killElevator();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
