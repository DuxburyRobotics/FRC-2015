package org.usfirst.frc.team4908.robot.commands;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowerElevatorAction extends CommandGroup {
	
	public LowerElevatorAction() {
		super("Lower Elevator");
		
		requires(Robot.elevator);
		addSequential(new PIDTestCommand(0.0));
		addSequential(new ZeroElevatorCommand());
	}
}
