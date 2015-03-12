package org.usfirst.frc.team4908.robot.commands.autonomous;

import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoIntakeCommand extends Command {
	
	private double timeInterval;
	private boolean indefiniteIntake;
	
	public AutoIntakeCommand() {
		super("Autonomous Intake");
		
		this.indefiniteIntake = true;
		this.timeInterval = 0.0;
		requires(Robot.intake);
	}
	
	public AutoIntakeCommand(double timeInterval) {
		super("Autonomous Intake");
		
		this.indefiniteIntake = false;
		this.timeInterval = timeInterval;
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {
		if (!indefiniteIntake) {
			setTimeout(timeInterval);
		}
		
		Robot.intake.setIntakePower(1.0);
	}

	@Override
	protected void execute() { }

	@Override
	protected boolean isFinished() {
		if (indefiniteIntake) {
			return Robot.intake.containsTote();
		}
		
		return this.isTimedOut();
	}

	@Override
	protected void end() {
		Robot.intake.stopIntakeMotors();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
