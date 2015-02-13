package org.usfirst.frc.team4908.robot.commands;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PositionElevatorCommand extends Command {
	
	private int setpoint;
	
	public PositionElevatorCommand(int setpoint) {
		super("Position Arms");
		
		this.setpoint = setpoint;
		requires(Robot.elevator);
	}

	@Override
	protected void initialize() {
		Robot.elevator.setSetpoint(setpoint);
		Robot.elevator.enable();
	}

	@Override
	protected void execute() { }

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.elevator.disable();
		Robot.elevator.brakeElevator();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
