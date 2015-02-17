package org.usfirst.frc.team4908.robot.commands;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ControlElevatorCommand extends Command {
	
	public ControlElevatorCommand() {
		super("Position Arms");
		
		requires(Robot.elevator);
	}

	@Override
	protected void initialize() {
		Robot.elevator.enable();
	}

	@Override
	protected void execute() {
		SmartDashboard.putNumber("Elevator Height", Robot.elevator.elevatorEncoder.get());
	}

	@Override
	protected boolean isFinished() {
		return false;
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
