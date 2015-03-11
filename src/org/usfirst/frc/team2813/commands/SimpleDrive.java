package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

public class SimpleDrive {
	
	double value;

	public void driveForward(double value) {
		
		Robot.pIDDrive.tankDrive(value, -value);
		
	}
}
