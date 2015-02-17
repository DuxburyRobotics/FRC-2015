package org.usfirst.frc.team4908.robot.commands.elevator;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PositionElevatorCommand extends Command {

	private int desiredPostion;
	
	public PositionElevatorCommand(int desiredPosition) {
		super("Position Elevator");
		
		this.desiredPostion = desiredPosition;
		requires(Robot.elevator);
	}
	
	@Override
	protected void initialize() {
		Robot.elevator.setDesiredPosition(desiredPostion);
	}

	@Override
	protected void execute() { }

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() { }

	@Override
	protected void interrupted() {
		end();
	}
}
