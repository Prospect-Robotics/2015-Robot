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
		Robot.elevator.elevatorSet(0.4, "down");
		while (true) {
			if (!RobotMap.elevatorelevatorMagnet.get())
				break;
		}
		Robot.elevator.resetEncoder();
		Robot.elevator.elevatorSet(0.4, "up");
		while (true) {
			if (Robot.elevator.maxHeight()) {
				Robot.elevator.elevatorStop();
				break;
			}
		Robot.elevator.setMaxValue();
		}
		Robot.elevator.enable();
		Robot.elevator.setSetpoint(Robot.elevator.getEncoderValue() / 2);

	}

	protected void execute() {

	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
