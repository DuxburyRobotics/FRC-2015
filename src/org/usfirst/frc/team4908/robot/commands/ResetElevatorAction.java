package org.usfirst.frc.team4908.robot.commands;

import org.usfirst.frc.team4908.robot.Robot;
import org.usfirst.frc.team4908.robot.misc.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ResetElevatorAction extends CommandGroup {
	
	/**
	 * Slowly lowers the elevator until the limit switch is hit. Zeroes elevator
	 * encoder and resets it. Then moves up 300 pulses.
	 */

	public ResetElevatorAction() {
		super("Reset Elevator");
		
		requires(Robot.elevator);
		
		addSequential(new ZeroElevatorCommand(0.3));
		addSequential(new PositionElevatorCommand(Constants.TOTE_CARRY_HEIGHT));
	}
}
