package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.subsystems.Elevator;

/**
 *
 */
public class ElevatorIncUp extends Elevator {

	boolean done = false;
	boolean run = false;

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
		if (!run)
			done = true;
		else if (getMagnet()) {
			triggerElevatorPid();
			addCounter();
			done = true;
		}
	}

	protected boolean isFinished() {
		return done;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
