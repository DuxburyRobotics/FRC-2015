package org.usfirst.frc.team4908.robot.commands;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDTestCommand extends Command {

	private double position;
	
	public PIDTestCommand(double position) {
		super("PID Test");
		
		this.position = position;
		requires(Robot.elevator);
	}
	
	@Override
	protected void initialize() {
		Robot.elevator.setSetpoint(position);
		Robot.elevator.enable();
	}

	@Override
	protected void execute() { 
		SmartDashboard.putNumber("Encoder Distance", Robot.elevator.elevatorEncoder.get());
		if (Robot.elevator.isZeroed()) {
			Robot.elevator.resetElevator();
		}
	}

	@Override
	protected boolean isFinished() {
		return Robot.elevator.onTarget();	//TODO: Dependent on how well brake mode works
	}

	@Override
	protected void end() {
		Robot.elevator.disable();
		Robot.elevator.stopElevator();
		cancel();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
