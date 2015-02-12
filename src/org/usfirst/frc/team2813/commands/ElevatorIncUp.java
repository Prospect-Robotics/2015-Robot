package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;
import org.usfirst.frc.team2813.robot.RobotMap;
import org.usfirst.frc.team2813.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorIncUp extends Command {

	boolean done = false;
	boolean run = false;

	public ElevatorIncUp() {
		requires(Robot.elevator);
	}

	protected void initialize() {
		//disable the PID
		if (Robot.elevator.counterMax())
			run = false;
		else
			Robot.elevator.elevatorUp();
	}

	protected void execute() {
		if (!run)
			done = true;
		else if (!RobotMap.elevatorelevatorMagnet.get()) {
			Robot.elevator.triggerElevatorPid();
			Robot.elevator.addCounter();
			done = true;
		}
	}

	protected boolean isFinished() {
		return done;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
