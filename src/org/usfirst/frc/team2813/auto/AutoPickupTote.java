package org.usfirst.frc.team2813.auto;

import org.usfirst.frc.team2813.commands.ClawIn;
import org.usfirst.frc.team2813.commands.ClawOut;
import org.usfirst.frc.team2813.commands.ElevatorOneTote;
import org.usfirst.frc.team2813.commands.ElevatorPickup;
import org.usfirst.frc.team2813.commands.IntakeLongTote;
import org.usfirst.frc.team2813.commands.IntakeWideTote;
import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoPickupTote extends Command {

	public AutoPickupTote() {
		requires(Robot.elevator);
		requires(Robot.carriage);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.elevator.resetEncoder();
		Robot.elevator.enable();
		ElevatorOneTote();
		Timer.delay(1.0);
		Robot.intakePivotLeft.enable();
		Robot.intakePivotRight.enable();
		IntakeIn();
		RollerSuck();
		ClawOut();
		Timer.delay(0.2);
		ElevatorPickup();
		Timer.delay(1.0);
		ClawIn();
		Timer.delay(0.3);
		ElevatorOneTote();
		Timer.delay(0.5);
		Forward(0.4);
		RollerSpit();
		Timer.delay(0.5);
		IntakeOut();
		RollerSuck();
		Timer.delay(0.5);
		IntakeIn();
		Stop();
		ClawOut();
		Timer.delay(0.2);
		ElevatorPickup();
		Timer.delay(1.4);
		ClawIn();
		Timer.delay(0.3);
		ElevatorOneTote();
		Timer.delay(0.3);
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

	protected void ClawIn() {
		ClawIn.ClawIn();
	}

	protected void ClawOut() {
		ClawOut.ClawOut();
	}

	protected void Forward(double speed) {
		double rotation = Robot.pIDDrive.getPIDout();
		Robot.pIDDrive.mecanumCartesian(0, speed, rotation, 0);
	}

	protected void Backward(double speed) {
		double rotation = Robot.pIDDrive.getPIDout();
		Robot.pIDDrive.mecanumCartesian(0, -speed, rotation, 0);
	}
	
	protected void Stop() {
		double rotation = Robot.pIDDrive.getPIDout();
		Robot.pIDDrive.mecanumCartesian(0, 0, rotation, 0);
	}

	protected void IntakeIn() {
		IntakeLongTote.IntakeLong();
	}

	protected void IntakeOut() {
		IntakeWideTote.IntakeWide();
	}

	protected void RollerSuck() {
		Robot.intakeRollers.intakeSpit();
	}

	protected void RollerSpit() {
		Robot.intakeRollers.intakeSuck();
	}

	protected void ElevatorPickup() {
		Robot.elevator.setSetpoint(ElevatorPickup.value);
	}

	protected void ElevatorDropTote() {
		double value = Robot.elevator.getEncoderValue() - 150;
		if (Robot.elevator.getEncoderValue() <= 150) {
		} else {
			Robot.elevator.setSetpoint(value);
		}
	}
	
	protected void ElevatorOneTote() {
		Robot.elevator.setSetpoint(ElevatorOneTote.value);
	}
}
