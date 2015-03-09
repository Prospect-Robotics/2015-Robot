package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorIncDown extends Command {

	boolean done = false;
	boolean run = true;

	public ElevatorIncDown() {

		requires(Robot.elevator);
	}

	protected void initialize() {
	}

	protected void execute() {

	}

	protected boolean isFinished() {
		return done;
	}

	protected void end() {
		done = false;
	}

	protected void interrupted() {
	}
}
