package org.usfirst.frc.team2813.commands;

/**
 * Created by Timothy on 2/11/2015.
 */

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2813.robot.Robot;

public class FODrive extends Command {
	double x, y;
	double rotation;
	float gyroAngle;

	public FODrive() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.pIDDrive);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.oi.getdriver1().getRawButton(1)) {
			Robot.pIDDrive.tankDrive(Robot.oi.driver1.getY(),
					Robot.oi.driver2.getY());
		} else {
			rotation = Robot.oi.getdriver2().getTwist();
			gyroAngle = Robot.nav6.getYaw();
			if (Robot.oi.driver1.getRawButton(1)) {
				x = Robot.oi.driver1.getX() / 2;
				y = Robot.oi.driver1.getY() / 4;
			} else {
				x = Robot.oi.driver1.getX();
				y = Robot.oi.driver1.getY();
			}
			SmartDashboard.putNumber("x", x);
			SmartDashboard.putNumber("y", y);
			SmartDashboard.putNumber("z", rotation);
			SmartDashboard.putNumber("gyro", gyroAngle);
			Robot.pIDDrive.mecanumCartesian(x, y, rotation, gyroAngle);
		}
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
}