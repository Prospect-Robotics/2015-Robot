package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

public class ReachedSetpoint {
	
	protected static double value;
	
	protected static void checkpoint() {
		while(true) {
			if (reached()) {
				break;
			}
		}
		
	}
	
	protected static boolean reached() {
		if (Robot.elevator.getEncoderValue() >= value - 4
				&& Robot.elevator.getEncoderValue() <= value + 4) {
			return true;
		} else {
			return false;
		}

	}
	
	public static void checkSetpoint(double temp) {
		value = temp;
		checkpoint();
		
	}

}
