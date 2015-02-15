package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;
import org.usfirst.frc.team2813.robot.RobotMap;

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
		// disable the PID
		if (Robot.elevator.getCounter() == 0)
			run = false;
		else
			Robot.elevator.elevatorUp();
	}

	protected void execute() {
		if (!run)
			done = true;
		else if (RobotMap.elevatorelevatorMagnet.get()) {
			Robot.elevator.triggerElevatorPid();
			Robot.elevator.minusCounter();
			done = true;
		}
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
