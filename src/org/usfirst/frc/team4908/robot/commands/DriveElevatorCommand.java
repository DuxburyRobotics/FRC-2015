package org.usfirst.frc.team4908.robot.commands;

import org.usfirst.frc.team4908.robot.OI;
import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveElevatorCommand extends Command {
	
	//BROKEN CLASS IGNORE FOR NOW
	
	private double power;
	
	public DriveElevatorCommand(double power) {
		super("DriveElevator");
		this.power = power;
		requires(Robot.elevator);
	}

	@Override
	protected void initialize() {
		//Robot.elevator.setMotor(1.0);
	}

	@Override
	protected void execute() { 
		
	}

	@Override
	protected boolean isFinished() {
		return !OI.RIGHT_STICK.getButton(1).get();
	}

	@Override
	protected void end() {
		//Robot.elevator.stopMotor();
	}

	@Override
	protected void interrupted() {
		end();
	}
}