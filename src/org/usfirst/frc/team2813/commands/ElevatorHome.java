package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;
import org.usfirst.frc.team2813.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorHome extends Command {

	public ElevatorHome() {

		requires(Robot.elevator);
	}

	protected void initialize() {
		Robot.elevator.disable();
		Robot.elevator.elevatorSet(0.1, "up");
	}

	protected void execute() {
		while(true) {
			if(!RobotMap.elevatorelevatorMagnet.get())
				break;
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
