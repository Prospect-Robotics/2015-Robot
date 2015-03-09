package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorJogUp extends Command {

	boolean done;

	public ElevatorJogUp() {
		requires(Robot.elevator);

	}

	protected void initialize() {
		Robot.elevator.disable();

		done = false;

	}

	protected void execute() {
		if (Robot.elevator.maxHeight()) {
			Robot.elevator.elevatorStop();
			done = true;
		} else {
			Robot.elevator.elevatorUp();
		}
	}

	protected boolean isFinished() {
		return done;
	}

	protected void end() {
		Robot.elevator.elevatorStop();
	}

	protected void interrupted() {
		Robot.elevator.elevatorStop();
		// Enable Pid
	}

}