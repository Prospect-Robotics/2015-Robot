package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorJogUp extends Command {

	public ElevatorJogUp() {
		requires(Robot.elevator);

	}

	protected void initialize() {
		// disable PID

	}

	protected void execute() {
		Robot.elevator.elevatorUp();
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
		Robot.elevator.elevatorStop();
	}

	protected void interrupted() {
		Robot.elevator.elevatorStop();
		// Enable Pid
	}

}