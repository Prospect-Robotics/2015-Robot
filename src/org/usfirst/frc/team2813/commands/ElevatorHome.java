package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;
import org.usfirst.frc.team2813.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorHome extends Command {

	boolean done = false;

	public ElevatorHome() {

		requires(Robot.elevator);
	}

	protected void initialize() {
		done = false;
		//IntakeDropTote.intakeDropTote();
		Robot.elevator.disable();
		Robot.elevator.elevatorSet(-0.3, "down");

	}

	protected void execute() {
		if (!RobotMap.elevatorelevatorMagnet.get()) {
			Robot.elevator.elevatorStop();
			Robot.elevator.resetEncoder();
			ElevatorOneTote.set();
			done = true;
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
	}
}
