package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.subsystems.Elevator;

/**
 *
 */
public class ElevatorIncUp extends Elevator {

	boolean done = false;
	boolean run = false;
	double pidset;

	public ElevatorIncUp() {
	}

	protected void initialize() {
		//disable the PID
		if (counterMax())
			run = false;
		else
			elevatorUp();
	}

	protected void execute() {
		if (getMagnet()) {
			
			done = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return done;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
