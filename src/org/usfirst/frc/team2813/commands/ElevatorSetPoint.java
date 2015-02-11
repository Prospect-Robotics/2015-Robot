package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.subsystems.Elevator;

/**
 *
 */
public class ElevatorSetPoint extends Elevator {

	int elevatorSet;
	boolean run = true;
	boolean done = false;

	public ElevatorSetPoint() {

	}

	protected void initialize() {
		// disable PID
		if (elevatorSet < getCounter())
			elevatorDown();
				else if (elevatorSet > getCounter())
			elevatorUp();
		else
			run = false;
	}

	protected void execute() {
		if (!run)
			done = true;
		while(getCounter() != elevatorSet) {
			counterAddCustom(elevatorSet);
			done = true;
		}
	}

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

	public void setElevator(int numberSet) {
		elevatorSet = numberSet;
	}
}