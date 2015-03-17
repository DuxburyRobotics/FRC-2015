package org.usfirst.frc.team4908.robot.commands.elevator;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PositionElevatorFinishableCommand extends Command {

private int desiredPostion;
	
	public PositionElevatorFinishableCommand(int desiredPosition) {
		super("Position Elevator Finishable");
		
		this.desiredPostion = desiredPosition;
		requires(Robot.elevator);
	}
	
	@Override
	protected void initialize() {
		Robot.elevator.setDesiredPosition(desiredPostion);
		Robot.elevator.enable();
	}

	@Override
	protected void execute() { }

	@Override
	protected boolean isFinished() {
		return Robot.elevator.onTarget();
	}

	@Override
	protected void end() { 
		Robot.elevator.disable();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
