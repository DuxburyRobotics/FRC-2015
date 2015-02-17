package org.usfirst.frc.team4908.robot.commands.elevator;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MaxElevatorCommand extends Command {
	
	private double power;
	
	public MaxElevatorCommand(double power) {
		super("Max Elevator");
		
		this.power = power;
		requires(Robot.elevator);
	}

	@Override
	protected void initialize() {
		if (!Robot.elevator.isMaxedOut()) {
			Robot.elevator.setElevatorPower(-power);
		}
	}

	@Override
	protected void execute() { }

	@Override
	protected boolean isFinished() {
		return Robot.elevator.isMaxedOut();
	}

	@Override
	protected void end() {
		Robot.elevator.brakeElevator();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
