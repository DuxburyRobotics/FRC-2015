package org.usfirst.frc.team4908.robot.commands.elevator;

import org.usfirst.frc.team4908.robot.Robot;
import org.usfirst.frc.team4908.robot.misc.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SkimStackCommand extends CommandGroup {

	public SkimStackCommand() {
		super("Skim Stack");
		
		requires(Robot.elevator);		
		addSequential(new PositionElevatorFinishableCommand((int)((double)Constants.TOTE_CARRY_HEIGHT/2.0)));
	}
}
