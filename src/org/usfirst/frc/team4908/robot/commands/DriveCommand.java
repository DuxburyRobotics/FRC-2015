package org.usfirst.frc.team4908.robot.commands;

import org.usfirst.frc.team4908.robot.OI;
import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command {
	
	public DriveCommand() {
		super("Drive");
		requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() { }

	@Override
	protected void execute() {
		Robot.driveTrain.driveTeleop(OI.RIGHT_STICK.getJoystick());
	}

	@Override
	protected boolean isFinished() {
		return false;
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
