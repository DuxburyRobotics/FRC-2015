package org.usfirst.frc.team4908.robot;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoChooser {

	private static AutoChooser instance = null;
	private ArrayList<Command> autoCommands;
	private int index;
	private boolean pressed;
	
	private AutoChooser() {
		autoCommands = new ArrayList<Command>();
		index = 0;
		pressed = false;
	}
	
	public static AutoChooser getChooser() {
		if (instance == null) {
			instance = new AutoChooser();
		}
		
		return instance;
	}
	
	public void addSequence(Command autoCommand) {
		autoCommands.add(autoCommand);
	}
	
	public void cycleCommands() {
		index++;
		if (index >= autoCommands.size()) {
			index = 0;
		}
	}
	
	public void update() {
		if (OI.LEFT_STICK.getButton(8).get() && !pressed) {
			AutoChooser.getChooser().cycleCommands();
			SmartDashboard.putString("AUTO", AutoChooser.getChooser().getCurrentSequence().getName());
			pressed = true;
		} else if (!OI.LEFT_STICK.getButton(8).get() && pressed) { 
			pressed = false;
		}
	}
	
	public Command getCurrentSequence() {
		return autoCommands.get(index);
	}
}
