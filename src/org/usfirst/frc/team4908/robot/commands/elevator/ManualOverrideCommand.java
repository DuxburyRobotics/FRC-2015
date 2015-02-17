package org.usfirst.frc.team4908.robot.commands.elevator;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ManualOverrideCommand extends Command {
	
	public ManualOverrideCommand() {
		super("Manual Override");
		
		requires(Robot.elevator);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		//Robot.elevator.setElevatorPower(OI.);
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
		end();
	}
}