package org.usfirst.frc.team4908.robot.misc;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Creates and initializes a Joystick and its buttons
 */
public class FullJoystick {
	
	public enum ButtonState {
		PRESSED,
		RELEASED,
		HELD
	}

    private Joystick joystick;
    private ArrayList<SmartButton> buttons;
    
    public FullJoystick(final Joystick joystick) {
        this.joystick = joystick;
        this.buttons = new ArrayList<>();
    }
    
    public Joystick getJoystick() {
        return joystick;
    }
    
    /**
     * Set's a command to a certain button on the joystick
     * 
     * @param buttonIndex - the number on the joystick referring to the button
     * @param command - the command you want the button to run
     * @param state - which state the button must be in to trigger action
     */
    public void setButton(final int buttonIndex, final Command command, final ButtonState state) {
    	SmartButton button = null;
    	for (SmartButton b : buttons) {
    		if (b.getButtonIndex() == buttonIndex) {
    			button = b;
    			break;
    		}
    	}
    	
    	if (button == null) {
    		button = new SmartButton(joystick, buttonIndex);
            buttons.add(button);
    	}
    	
        switch (state) {
            case PRESSED:
                button.whenPressed(command);
                break;
            case RELEASED:
                button.whenReleased(command);
                break;
            case HELD:
                button.whileHeld(command);
                break;
            default:
                button.whileHeld(command);
        }        
    }
}
