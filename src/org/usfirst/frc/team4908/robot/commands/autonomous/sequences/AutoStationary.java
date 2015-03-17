package org.usfirst.frc.team4908.robot.commands.autonomous.sequences;

import org.usfirst.frc.team4908.robot.commands.elevator.ZeroElevatorCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoStationary extends CommandGroup {

	public AutoStationary() {
		super("Stationary");
		
		addSequential(new ZeroElevatorCommand(0.3));
	}
}
