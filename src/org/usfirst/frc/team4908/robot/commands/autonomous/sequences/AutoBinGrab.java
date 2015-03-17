package org.usfirst.frc.team4908.robot.commands.autonomous.sequences;

import org.usfirst.frc.team4908.robot.commands.autonomous.AutoIntakeCommand;
import org.usfirst.frc.team4908.robot.commands.autonomous.DriveForwardCommand;
import org.usfirst.frc.team4908.robot.commands.autonomous.TurnCommand;
import org.usfirst.frc.team4908.robot.commands.autonomous.TurnCommand.Direction;
import org.usfirst.frc.team4908.robot.commands.elevator.MaxElevatorCommand;
import org.usfirst.frc.team4908.robot.commands.elevator.ZeroElevatorCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoBinGrab extends CommandGroup {

	public AutoBinGrab() {
		super("Bin Grab [NOT WORKING]");
		
		addSequential(new ZeroElevatorCommand(0.3));
		
		addParallel(new AutoIntakeCommand(0.3));
		addSequential(new MaxElevatorCommand(0.3));
		
		addSequential(new TurnCommand(Direction.CLOCKWISE));
		
		addSequential(new DriveForwardCommand(20.0));
	}
}
