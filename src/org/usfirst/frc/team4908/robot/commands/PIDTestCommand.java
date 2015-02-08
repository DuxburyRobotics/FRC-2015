package org.usfirst.frc.team4908.robot.commands;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDTestCommand extends Command {

	private double position;
	private boolean alreadyZeroed;
	
	public PIDTestCommand(double position) {
		super("PID Test");
		
		this.position = position;
		requires(Robot.elevator);
	}
	
	@Override
	protected void initialize() {
		alreadyZeroed = false;
		Robot.elevator.setSetpoint(position);
		Robot.elevator.enable();
	}

	@Override
	protected void execute() { 
		SmartDashboard.putNumber("Encoder Count", Robot.elevator.elevatorEncoder.get());
		SmartDashboard.putNumber("Position", (int)position);
		if (position == 0.0 && !alreadyZeroed && Robot.elevator.isZeroed()) {
			Robot.elevator.resetElevator();
			alreadyZeroed = true;
			SmartDashboard.putNumber("Encoder Count", Robot.elevator.elevatorEncoder.get());
		}
	}

	@Override
	protected boolean isFinished() {
		return Robot.elevator.onTarget() || (position == 0.0 && Robot.elevator.isZeroed());	//TODO: Dependent on how well brake mode works
	}

	@Override
	protected void end() {
		Robot.elevator.disable();
		Robot.elevator.brakeElevator();
		//cancel();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
