package org.usfirst.frc.team4908.robot.commands.autonomous;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnCommand extends Command {
	
	public TurnCommand() {
		super("Turn");
		
		requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() {
		Robot.driveTrain.resetDriveEncoders();
		Robot.driveTrain.setDrivePower(0.5, -0.5);
	}

	@Override
	protected void execute() {
		Robot.driveTrain.setDrivePower(0.5, -0.5);

		SmartDashboard.putNumber("TURN", Robot.driveTrain.getRightEncoder().get());
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
