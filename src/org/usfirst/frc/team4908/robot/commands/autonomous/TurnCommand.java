package org.usfirst.frc.team4908.robot.commands.autonomous;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnCommand extends Command {
	
	public enum Direction {
		CLOCKWISE,
		COUNTER_CLOCKWISE
	}
	
	double leftPower = 0.0;
	double rightPower = 0.0;
		
	public TurnCommand(Direction direction) {
		super("Turn");
		
		requires(Robot.driveTrain);
		
		switch (direction) {
			case CLOCKWISE:
				leftPower = 0.5;
				rightPower = -0.5;
				break;
			
			case COUNTER_CLOCKWISE:
				leftPower = -0.5;
				rightPower = 0.5;
				break;
		}
	}

	@Override
	protected void initialize() {
		Robot.driveTrain.resetDriveEncoders();
		Robot.driveTrain.setDrivePower(leftPower, rightPower);
	}

	@Override
	protected void execute() {
		Robot.driveTrain.setDrivePower(leftPower, rightPower);
	}

	@Override
	protected boolean isFinished() {
		return Robot.driveTrain.getRightEncoder().get() <= -240;
	}

	@Override
	protected void end() {
		Robot.driveTrain.stopDriving();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
