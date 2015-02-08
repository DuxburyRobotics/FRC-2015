package org.usfirst.frc.team4908.robot.commands;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ZeroElevatorCommand extends Command {
	
	public ZeroElevatorCommand() {
		super("Zero Elevator");
		
		requires(Robot.elevator);
	}

	@Override
	protected void initialize() {
		if (!Robot.elevator.isZeroed()) {	//Probably overkill, but I'd rather not take the risk
			Robot.elevator.setElevatorPower(0.1);	//TODO: Extract to constant
		}
	}

	@Override
	protected void execute() { 
		SmartDashboard.putBoolean("Switch", Robot.elevator.isZeroed());
		SmartDashboard.putNumber("Encoder Count", Robot.elevator.elevatorEncoder.get());
	}

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
