
package org.usfirst.frc.team4908.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4908.robot.commands.autonomous.AutonomousSequence;
//import org.usfirst.frc.team4908.robot.commands.elevator.ResetElevatorAction;
import org.usfirst.frc.team4908.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4908.robot.subsystems.Elevator;
import org.usfirst.frc.team4908.robot.subsystems.ActiveIntake;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveTrain driveTrain;
	public static Elevator elevator;
	public static ActiveIntake intake;
	
	private CameraServer camera;	
	private AutonomousSequence autoSequence;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	@Override
    public void robotInit() {
    	driveTrain = new DriveTrain();
    	elevator = new Elevator();
    	intake = new ActiveIntake();
		oi = new OI();
		
		camera = CameraServer.getInstance();
		camera.setQuality(25);
		camera.startAutomaticCapture("cam0");
		
		autoSequence = new AutonomousSequence();
    }
	
    @Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    @Override
    public void autonomousInit() {
        if (autoSequence != null)
        	autoSequence.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        if (autoSequence != null) 
        	autoSequence.cancel();
        
        //elevator.resetElevator();
        //ResetElevatorAction resetElevator = new ResetElevatorAction();
        //resetElevator.start();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit() {
    	elevator.brakeElevator();
    	intake.stopIntakeMotors();
    	driveTrain.stopDriving();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }
}
