package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

public class SimpleDrive {
	
	public static void driveForward(double value) {
		Robot.pIDDrive.Drive(value, -value);
	}
}
