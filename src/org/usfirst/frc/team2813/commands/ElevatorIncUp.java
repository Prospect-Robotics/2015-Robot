package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorIncUp extends Command {

	boolean done;
	boolean run = true;
	
	double value = 200;

	public ElevatorIncUp() {
		requires(Robot.elevator);
	}

	protected void initialize() {
		done=false;
		Robot.elevator.disable();

	}

	protected void execute() {
		if (Robot.elevator.maxHeight()) {
			done = true;
		}
		else {
			Robot.elevator.enable();
			Robot.elevator.setSetpoint(value);
		}
	}

	protected boolean isFinished() {
		return done;
	}

	protected void end() {
		done = false;
		System.out.print("ElevatorIucUP Done");
	}

	protected void interrupted() {
	}
}
