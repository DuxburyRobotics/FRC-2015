package org.usfirst.frc.team4908.robot.commands.autonomous.sequences;

import org.usfirst.frc.team4908.robot.commands.autonomous.DriveForwardCommand;
import org.usfirst.frc.team4908.robot.commands.elevator.ZeroElevatorCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoForward extends CommandGroup {

	public AutoForward() {
		super("Drive Forward");
		
		addParallel(new ZeroElevatorCommand(0.3));
		addParallel(new DriveForwardCommand(23.0));
	}
}