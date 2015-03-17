package org.usfirst.frc.team4908.robot;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.command.Command;

public class AutoChooser {

	private static AutoChooser instance = null;
	private ArrayList<Command> autoCommands;
	private int index;
	
	private AutoChooser() {
		autoCommands = new ArrayList<Command>();
		index = 0;
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
	
	public Command getCurrentSequence() {
		return autoCommands.get(index);
	}
}
