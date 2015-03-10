package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorDropTote extends Command {

	int elevatorSet;
	boolean run = true;
	boolean done = false;

	public static double value = Robot.elevator.getEncoderValue() - 150;

	public ElevatorDropTote() {
		requires(Robot.elevator);

	}

	protected void initialize() {
		Robot.elevator.disable();
		done = false;
		value = Robot.elevator.getEncoderValue() - 150;
		if (Robot.elevator.getEncoderValue() <= 150)
			Robot.elevator.disable();
		else {
			Robot.elevator.enable();
			Robot.elevator.setSetpoint(value);
		}

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
		if (Robot.elevator.getEncoderValue() >= value - 5
				&& Robot.elevator.getEncoderValue() <= value + 5) {
			return true;
		} else {
			return false;
		}

	}

}
