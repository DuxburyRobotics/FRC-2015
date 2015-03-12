package org.usfirst.frc.team4908.robot.commands;

import org.usfirst.frc.team4908.robot.Robot;
import org.usfirst.frc.team4908.robot.commands.elevator.PositionElevatorCommand;
import org.usfirst.frc.team4908.robot.commands.elevator.ZeroElevatorCommand;
import org.usfirst.frc.team4908.robot.misc.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GrabGamePieceAction extends CommandGroup {
	
	public GrabGamePieceAction() {
		super("Grab Game Piece");
		
		requires(Robot.elevator);
		addSequential(new ZeroElevatorCommand(0.4));
		addSequential(new PositionElevatorCommand(Constants.TOTE_CARRY_HEIGHT));
	}
}
