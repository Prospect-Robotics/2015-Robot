package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorReset extends Command {
	
	boolean done;

	public ElevatorReset() {
		requires(Robot.elevator);
	}

	protected void initialize() {
		done = false;
		Robot.elevator.resetEncoder();
		done = true;
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return done;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
