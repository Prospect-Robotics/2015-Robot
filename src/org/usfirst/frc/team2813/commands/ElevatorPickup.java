package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorPickup extends Command {

	int elevatorSet;
	boolean run = true;
	boolean done = false;

	public static double value = -570;

	public ElevatorPickup() {
		requires(Robot.elevator);

	}

	protected void initialize() {
		done = false;
		Robot.elevator.enable();
		Robot.elevator.setSetpoint(value);
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
		Robot.elevator.disable();
	}

	public static boolean inPosition() {
		return Robot.elevator.onTarget();
		/*if (Robot.elevator.getEncoderValue() >= value - 5
				&& Robot.elevator.getEncoderValue() <= value + 5) {
			return true;
		} else {
			return false;
		}*/

	}

}
