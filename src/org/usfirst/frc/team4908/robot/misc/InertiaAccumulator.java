package org.usfirst.frc.team4908.robot.misc;

/* Idea from 254 */

public class InertiaAccumulator {
	
	private double multiplier;
	private double runningTotal;
	private double lastSpeed;
	
	public InertiaAccumulator(double multiplier) {
		this.multiplier = multiplier;
		this.runningTotal = 0.0;
		this.lastSpeed = 0.0;
	}
	
	public double adjustRotationalSpeed(double rotationalSpeed) {
		double currentSpeed = rotationalSpeed;
		double negativeInertia = currentSpeed - lastSpeed;
		
		lastSpeed = currentSpeed;
		
		double niPower = negativeInertia * multiplier;
		runningTotal += niPower;
		currentSpeed += runningTotal;
		
		if (runningTotal > 1)
			runningTotal -= 1;
		else if (runningTotal < -1)
			runningTotal += 1;
		else
			runningTotal = 0;
		
		return currentSpeed;
	}
}
