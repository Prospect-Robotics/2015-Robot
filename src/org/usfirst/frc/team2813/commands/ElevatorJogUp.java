package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;
import org.usfirst.frc.team2813.subsystems.Elevator;

/**
 *
 */
public class ElevatorJogUp extends Elevator {

	public ElevatorJogUp() {

	}

	protected void initialize() {
		// disable PID

	}

	protected void execute() {
		elevatorUp();
		if (Robot.elevator.getMagnet()) {
			Robot.elevator.addCounter();
			if (Robot.elevator.getCounter() >= 4) {
				Robot.elevator.elevatorStop();
							}
						}

	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		elevatorStop();
	}

	protected void interrupted() {
		elevatorStop();
		// Enable Pid
	}

}