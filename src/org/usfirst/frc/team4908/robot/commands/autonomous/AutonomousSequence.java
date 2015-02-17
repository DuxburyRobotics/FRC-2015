package org.usfirst.frc.team4908.robot.commands.autonomous;

import org.usfirst.frc.team4908.robot.commands.elevator.MaxElevatorCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousSequence extends CommandGroup {

	public AutonomousSequence() {
		super("Autonomous Sequence");
		
		/* Order of events
		 * 
		 * 1. Drive forward 18.6in while using intake to bring in bin
		 * 2. Lift bin to maximum elevator height
		 * 3. Drive forward Xin while using intake until tote is inside robot
		 * 4. Turn 90 degrees
		 * 5. Drive forward Xin
		 * 6. Eject tote from robot using intakes
		 */
		
		addParallel(new DriveForwardCommand(18.6));
		addParallel(new AutoIntakeCommand(5.0));
		addSequential(new MaxElevatorCommand(0.4));
		
//		addParallel(new DriveForwardCommand(-1.0));
//		addParallel(new AutoIntakeCommand());
		
		
	}
}
