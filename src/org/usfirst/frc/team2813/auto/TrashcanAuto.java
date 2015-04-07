package org.usfirst.frc.team2813.auto;

import org.usfirst.frc.team2813.commands.ElevatorHome;
import org.usfirst.frc.team2813.commands.SimpleDrive;
import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TrashcanAuto extends Command {

	public TrashcanAuto() {
		requires(Robot.nav6);
		requires(Robot.pIDDrive);
		requires(Robot.trashcanGrabber);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		/*
		 * Robot.nav6.resetNav6(); Robot.pIDDrive.enable();
		 * Robot.pIDDrive.setSetpoint(Robot.nav6.pidGet()); double rotation =
		 * Robot.pIDDrive.getPIDout(); while (true) { if
		 * (Robot.trashcanGrabber.isTrue()) { break;
		 * 
		 * } if (Robot.oi.getdriver1().getRawButton(1)) { break; } }
		 * 
		 * Robot.pIDDrive.mecanumCartesian(0, 0, rotation, 0); Timer.delay(1.0);
		 * Robot.trashcanGrabber.setTrue();
		 */
		/*
		 * Timer.delay(2.0); while (System.currentTimeMillis() < end) {
		 * Robot.pIDDrive.mecanumCartesian(0, 0.5, 0, 0); delay(2.0); break; }
		 * Timer.delay(1.0); Robot.pIDDrive.mecanumCartesian(0, 0, rotation, 0);
		 * Robot.trashcanGrabber.setFalse();
		 */Command autocommand;
		autocommand = new ElevatorHome();

		Robot.nav6.resetNav6();
		Robot.pIDDrive.enable();
		autocommand.start();
		Robot.pIDDrive.setSetpoint(Robot.nav6.pidGet());
		double rotation = Robot.pIDDrive.getPIDout();
		Robot.pIDDrive.mecanumCartesian(0, 0.4, rotation, 0);
		Timer.delay(0.5);
		Robot.pIDDrive.mecanumCartesian(0, 0.2, rotation, 0);
		Timer.delay(0.5);
		Robot.trashcanGrabber.setTrue();
		Timer.delay(1.0);
		Robot.pIDDrive.mecanumCartesian(0, -0.6, rotation, 0);
		Timer.delay(1.0);
		Robot.pIDDrive.mecanumCartesian(0, 0, rotation, 0);
		Robot.trashcanGrabber.setFalse();

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
		SimpleDrive.driveForward(0.0);
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
