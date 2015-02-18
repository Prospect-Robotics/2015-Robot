package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorJogDown extends Command {

	public ElevatorJogDown() {
		requires(Robot.elevator);
	}

	protected void initialize() {
		// disable PID

	}

	protected void execute() {
		Robot.elevator.elevatorDown();
		if (Robot.elevator.getMagnet()) {
			Robot.elevator.minusCounter();
			if (Robot.elevator.getCounter() <= 0) {
				Robot.elevator.elevatorStop();
			}
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.elevator.elevatorStop();
	}

	protected void interrupted() {
		Robot.elevator.elevatorStop();
		// Enable Pid
	}

}