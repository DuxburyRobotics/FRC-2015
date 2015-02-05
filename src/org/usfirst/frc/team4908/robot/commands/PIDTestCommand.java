package org.usfirst.frc.team4908.robot.commands;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PIDTestCommand extends Command {

	private double position;
	
	public PIDTestCommand(double position)
	{
		this.position = position;
	}
	
	@Override
	protected void initialize() {
		Robot.elevator.setSetpoint(position);
	}

	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}

}
