package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorTwoTote extends Command {

	int elevatorSet;
	boolean run = true;
	boolean done = false;

	static double value = 116.25;

	public ElevatorTwoTote() {
		requires(Robot.elevator);

	}

	protected void initialize() {
		done = false;
		Robot.elevator.enable();
		Robot.elevator.setSetpoint(value);

	}

	protected void execute() {

	}

	protected boolean isFinished() {
		return done;
	}

	protected void end() {
	}

	protected void interrupted() {
		Robot.elevator.disable();
	}

	public static boolean inPosition() {
		return Robot.elevator.onTarget();
	}

}
