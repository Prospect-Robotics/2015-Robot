package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PickupRoutine extends Command {

	public PickupRoutine() {
		requires(Robot.carriage);
		requires(Robot.intakePivotRight);
		requires(Robot.intakePivotLeft);
		requires(Robot.intakeRollers);
		requires(Robot.elevator);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.elevator.enable();
		Robot.elevator.setSetpoint(ElevatorOneTote.value);
		ReachedSetpoint.checkSetpoint(ElevatorOneTote.value);
		Robot.elevator.setSetpoint(Robot.elevator.getEncoderValue()
				+ ElevatorDropTote.value);
		ReachedSetpoint.checkSetpoint(Robot.elevator.getEncoderValue()
				+ ElevatorDropTote.value);
		delay(0.7);
		ClawOut.ClawOut();
		delay(0.4);
		Robot.elevator.setSetpoint(ElevatorPickup.value);
		ReachedSetpoint.checkSetpoint(ElevatorPickup.value);
		delay(0.7);
		ClawIn.ClawIn();
		delay(0.4);
		Robot.elevator.setSetpoint(ElevatorGround.value);
		ReachedSetpoint.checkSetpoint(ElevatorGround.value);

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
	
	protected void delay(double seconds) {
		while (true) {
			setTimeout(seconds);
			if (isTimedOut()) {
				break;
			}
		}
	}
	
}
