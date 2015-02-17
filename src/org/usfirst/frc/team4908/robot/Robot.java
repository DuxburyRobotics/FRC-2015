
package org.usfirst.frc.team4908.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4908.robot.commands.autonomous.DriveForwardCommand;
import org.usfirst.frc.team4908.robot.commands.elevator.ResetElevatorAction;
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
	private DriveForwardCommand autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	driveTrain = new DriveTrain();
    	elevator = new Elevator();
    	intake = new ActiveIntake();
		oi = new OI();
		
		camera = CameraServer.getInstance(); 	//May need to be changed to cam1, etc
		camera.setQuality(25);
		camera.startAutomaticCapture("cam0");	//Add in smart dashboard
		
		autonomousCommand = new DriveForwardCommand(18.6);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null)
        	autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) 
        	autonomousCommand.cancel();
        
        elevator.resetElevator();
        //ZeroElevatorCommand zero = new ZeroElevatorCommand();
        //zero.start();
        ResetElevatorAction reset = new ResetElevatorAction();
        reset.start();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit() {
    	//TODO: Lower elevator to ground
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
