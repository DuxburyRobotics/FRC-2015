package org.usfirst.frc.team4908.robot.commands.elevator;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//TODO: For testing only, remove when done

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