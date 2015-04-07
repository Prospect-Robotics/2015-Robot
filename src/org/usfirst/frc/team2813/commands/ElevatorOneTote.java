package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorOneTote extends Command {

	int elevatorSet;
	boolean run = true;
	boolean done = false;
	
	public static double value = 680.5;

	public ElevatorOneTote() {
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
	}
	
	public static void set() {
		Robot.elevator.enable();
		Robot.elevator.setSetpoint(value);
	}

}
