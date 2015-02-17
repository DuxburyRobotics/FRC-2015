package org.usfirst.frc.team4908.robot.commands;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		if (!Robot.elevator.isZeroed()) {	//Probably overkill, but I'd rather not take the risk
			Robot.elevator.setSetpoint(0.0);
			Robot.elevator.setElevatorPower(power);	//TODO: Extract to constant
		}
		
		//SmartDashboard.putBoolean("Zeroed!", false);
	}

	@Override
	protected void execute() { 
		//SmartDashboard.putBoolean("Switch", Robot.elevator.isZeroed());
		//SmartDashboard.putNumber("Encoder Count", Robot.elevator.elevatorEncoder.get());
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
			//SmartDashboard.putBoolean("Zeroed!", true);
		}
	}

	@Override
	protected void interrupted() {
		end();
	}
}
