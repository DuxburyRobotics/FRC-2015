package org.usfirst.frc.team4908.robot.commands.elevator;

import org.usfirst.frc.team4908.robot.OI;
import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ControlElevatorCommand extends Command {
	
	public ControlElevatorCommand() {
		super("Position Elevator");
		
		requires(Robot.elevator);
	}

	@Override
	protected void initialize() {
		Robot.elevator.enable();
	}

	@Override
	protected void execute() {
		//Manual override
		if (OI.LEFT_STICK.getButton(7).get()) {
			int newPosition = Robot.elevator.getDesiredPosition() + 10;
			if (!Robot.elevator.isMaxedOut()) {
				Robot.elevator.setDesiredPosition(newPosition);
			}
		} else if (OI.LEFT_STICK.getButton(8).get()) {
			int newPosition = Robot.elevator.getDesiredPosition() - 10;
			if (newPosition > 0 && !Robot.elevator.isZeroed()) {
				Robot.elevator.setDesiredPosition(newPosition);
			}
		}
		
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
