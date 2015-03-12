package org.usfirst.frc.team4908.robot.misc;

public class Constants {
	
	//Joystick
    public static final int JOYSTICK_RIGHT_INDEX = 0;
    public static final int JOYSTICK_LEFT_INDEX = 1;
	
	//Drive Train
	public static final int LEFT_MOTOR_PORT = 4;
	public static final int RIGHT_MOTOR_PORT = 5;
	
	public static final double DRIVE_P = 0.0007;
	public static final double DRIVE_I = 0.000001;
	public static final double DRIVE_D = 0.00001;
	
	public static final int DRIVE_ENCODER_LEFT_A_PORT = 4;
	public static final int DRIVE_ENCODER_LEFT_B_PORT = 5;
	public static final int DRIVE_ENCODER_RIGHT_A_PORT = 2;
	public static final int DRIVE_ENCODER_RIGHT_B_PORT = 3;
	
    public static final double DRIVE_SENSITIVITY = 0.4;
    public static final double DRIVE_MIN_POWER = 0.0;
    public static final double DRIVE_MAX_POWER = 1.0;
    public static final int INERTIAL_MULTIPLIER = 3;
    
    public static final int DRIVE_ABSOLUTE_TOLERANCE = 5;
        
    //Elevator
    public static final int ELEVATOR_DRIVE_LMOTOR_PORT = 2;
    public static final int ELEVATOR_DRIVE_RMOTOR_PORT = 3;
    public static final int ELEVATOR_BOTTOM_LIMIT_PORT = 6;
    public static final int ELEVATOR_TOP_LIMIT_PORT = 8;
    
    public static final double ELEVATOR_P = 0.005;
    public static final double ELEVATOR_I = 0.0001;
    public static final double ELEVATOR_D = 0.0002;
    
    public static final double ELEVATOR_DRIVE_MULTIPLIER = 1.0;
    
    public static final int ELEVATOR_ENCODER_A_PORT = 0;
    public static final int ELEVATOR_ENCODER_B_PORT = 1;
    
    public static final int TOTE_CARRY_HEIGHT = 650;
    
    public static final int ELEVATOR_ABSOLUTE_TOLERANCE = 5;
    
    //Intake
    public static final int LEFT_INTAKE_MOTOR_PORT = 0;
    public static final int RIGHT_INTAKE_MOTOR_PORT = 1;
    
    public static final int TOTE_LIMIT_PORT = 7;
}
