package org.usfirst.frc.team4908.robot.commands.autonomous;

import org.usfirst.frc.team4908.robot.Robot;
import org.usfirst.frc.team4908.robot.misc.Constants;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveForwardCommand extends PIDCommand {
	
	private double distance;

	public DriveForwardCommand(double distance) {
		super(Constants.DRIVE_P, Constants.DRIVE_I, Constants.DRIVE_D);
		
		this.distance = Robot.driveTrain.convertToPulses((float)distance); //distance;
		getPIDController().setAbsoluteTolerance(Constants.DRIVE_ABSOLUTE_TOLERANCE);
		getPIDController().setOutputRange(-1.0, 1.0);
		requires(Robot.driveTrain);
	}

	@Override
	protected double returnPIDInput() {
		return (Math.abs(Robot.driveTrain.getLeftEncoder().get()) + Math.abs(Robot.driveTrain.getRightEncoder().get())) / 2.0;
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.driveTrain.setDrivePower(output);
	}

	@Override
	protected void initialize() {
		Robot.driveTrain.resetDriveEncoders();
		setSetpoint(distance);
		getPIDController().enable();
	}

	@Override
	protected void execute() { 
		SmartDashboard.putNumber("Distance Driven", (Math.abs(Robot.driveTrain.getLeftEncoder().get()) + Math.abs(Robot.driveTrain.getRightEncoder().get())) / 2.0);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		getPIDController().disable();
		Robot.driveTrain.stopDriving();
	}

	@Override
	protected void interrupted() {
		end();
	}	
}
