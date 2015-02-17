package org.usfirst.frc.team4908.robot.commands;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CalibrateElevatorCommand extends Command {
		
	public CalibrateElevatorCommand() {
		super("Calibrate Elevator");
		
		requires(Robot.elevator);
	}

	@Override
	protected void initialize() {
		SmartDashboard.putNumber("Elevator Height", Robot.elevator.elevatorEncoder.get());
		Robot.elevator.setElevatorPower(-0.2);
	}

	@Override
	protected void execute() {
		SmartDashboard.putNumber("Elevator Height", Robot.elevator.elevatorEncoder.get());
	}

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
