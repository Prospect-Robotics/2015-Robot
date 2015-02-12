package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorIncDown extends Command {

	boolean done = false;
	boolean run = false;

	public ElevatorIncDown() {
		requires(Robot.elevator);
	}

	protected void initialize() {
		// disable the PID
		if (Robot.elevator.getCounter() == 0)
			run = false;
		else
			Robot.elevator.elevatorUp();
	}

	protected void execute() {
		if (!run)
			done = true;
		else if (Robot.elevator.getMagnet()) {
			Robot.elevator.triggerElevatorPid();
			Robot.elevator.minusCounter();
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
