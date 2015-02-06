package org.usfirst.frc.team4908.robot.commands;

import org.usfirst.frc.team4908.robot.OI;
import org.usfirst.frc.team4908.robot.Robot;

import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Command;

public class ArmControlCommand extends Command {
	
	
	public ArmControlCommand() {
		super("Intake");
		requires(Robot.intake);
	}

	@Override
	protected void initialize() { }

	@Override
	protected void execute() {
		Robot.intake.rollIntakeWheels(OI.LEFT_STICK.getJoystick().getAxis(AxisType.kY));
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.intake.stopArmMotors();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
