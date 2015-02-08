package org.usfirst.frc.team4908.robot.commands;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GrabGamePieceAction extends CommandGroup {
	
	public GrabGamePieceAction() {
		super("Grab Game Piece");
		
		requires(Robot.elevator);
		
		addSequential(new LowerElevatorAction());
		addSequential(new PIDTestCommand(400.0));
	}
}
