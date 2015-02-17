package org.usfirst.frc.team4908.robot.commands;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ZeroElevatorCommand extends Command {
	
	private double power;
	
	public ZeroElevatorCommand() {
		super("Zero Elevator");
		
		this.power = 0.2;
		requires(Robot.elevator);
	}
	
	public ZeroElevatorCommand(double power) {
		super("Zero Elevator");
		
		this.power = power;
		requires(Robot.elevator);
	}

	@Override
	protected void initialize() {
		if (!Robot.elevator.isZeroed()) {
			Robot.elevator.setSetpoint(0.0);
			Robot.elevator.setElevatorPower(power);
		}		
	}

	@Override
	protected void execute() { }

	@Override
	protected boolean isFinished() {
		return Robot.elevator.isZeroed();
	}

	@Override
	protected void end() {
		Robot.elevator.brakeElevator();
		if (Robot.elevator.isZeroed()) {
			Robot.elevator.resetElevator();
		}
	}

	@Override
	protected void interrupted() {
		end();
	}
}
