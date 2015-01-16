package org.usfirst.frc.team4908.robot.misc;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Joystick.AxisType;

public class DragonDrive extends RobotDrive {
	
	private InertiaAccumulator ina;

	public DragonDrive(SpeedController frontLeftMotor, SpeedController rearLeftMotor, SpeedController frontRightMotor, SpeedController rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		ina = new InertiaAccumulator(Constants.INERTIAL_MULTIPLIER);
	}
	
	/**
	 * Single joystick drive that uses the joystick's twist axis to determine rotation
	 * @param joystick - Joystick to read from
	 */
	public void arcadeTwistDrive(final Joystick joystick) {
		double rotationalSpeed = joystick.getAxis(AxisType.kTwist);
		double driveSpeed = joystick.getAxis(AxisType.kY);
		
		arcadeDrive(driveSpeed, rotationalSpeed);
	}
	
	/**
	 * Test of negative inertia system. In theory should make robot control more intuitive
	 * by reducing or removing inertia-caused turning after the driver lets go of the 
	 * joystick. The INERTIAL_MULTIPLIER constant should be tweaked to whatever feels best.
	 * @param joystick
	 */
	public void negativeIntertiaDrive(final Joystick joystick) {
		double rotationalSpeed = -joystick.getAxis(AxisType.kTwist);
		double driveSpeed = -joystick.getAxis(AxisType.kY);
		
		arcadeDrive(driveSpeed, ina.adjustRotationalSpeed(rotationalSpeed));
	}
}