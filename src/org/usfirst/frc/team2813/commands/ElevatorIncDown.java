package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.subsystems.Elevator;

/**
 *
 */
public class ElevatorIncDown extends Elevator {

	boolean done = false;
	boolean run = false;

	public ElevatorIncDown() {

	}

	protected void initialize() {
		// disable the PID
		if (getCounter() == 0)
			run = false;
		else
			elevatorUp();
	}

	protected void execute() {
		if (!run)
			done = true;
		else if (getMagnet()) {
			triggerElevatorPid();
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
