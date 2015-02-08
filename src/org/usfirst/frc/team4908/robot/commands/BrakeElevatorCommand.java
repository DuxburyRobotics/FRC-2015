package org.usfirst.frc.team4908.robot.commands;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class BrakeElevatorCommand extends Command {
	
	public BrakeElevatorCommand() {
		super("Brake Elevator");
		
		requires(Robot.elevator);
	}

	@Override
	protected void initialize() { }

	@Override
	protected void execute() {
		Robot.elevator.brakeElevator();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() { }

	@Override
	protected void interrupted() {
		end();
	}
}
