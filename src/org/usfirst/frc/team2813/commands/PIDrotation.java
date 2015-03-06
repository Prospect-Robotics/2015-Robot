package org.usfirst.frc.team2813.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2813.robot.Robot;

/**
 *
 */
public class PIDrotation extends Command {
	double x, y;
	double rotation;
	float gyroAngle;
	boolean newSetpoint;

	boolean trigger = false; // placeholder for threshold or button or something

	public PIDrotation() {
		
		requires(Robot.pIDDrive);
	}

	protected void initialize() {
		Robot.pIDDrive.disable();
		Robot.pIDDrive.setSetpoint(Robot.nav6.pidGet()); // Set setpoint as current position
		Robot.pIDDrive.enable();
	}

	protected void execute() {
		SmartDashboard.putBoolean("Threshold", inthreshold(Robot.oi.driver2.getTwist(), .2));

		//Determine Rotation for Drive, with PID rotation correction
		// if (inthreshold(Robot.oi.joystick2.getTwist(), .2)) {
		if (Robot.oi.driver2.getTrigger()) {
			Robot.pIDDrive.disable();
			rotation = Robot.oi.driver2.getTwist();
			Robot.pIDDrive.setSetpoint(Robot.nav6.pidGet()); // Set setpoint as current position
		} else {
			Robot.pIDDrive.enable();
			rotation = Robot.pIDDrive.getPIDout();
		}
		//Determine x and y for Drive
		if (Robot.oi.driver1.getRawButton(1)) {
			x = Robot.oi.driver1.getX() / 2;
			y = Robot.oi.driver1.getY() / 4;
		} else {
			x = Robot.oi.driver1.getX();
			y = Robot.oi.driver1.getY();
		}
		//Determine Gyro Angle for Field Oriented Drive
		gyroAngle = Robot.nav6.getYaw();

		SmartDashboard.putNumber("Setpoint", Robot.pIDDrive.getSetpoint());
		SmartDashboard.putNumber("z", Robot.oi.driver2.getTwist());
		SmartDashboard.putNumber("Rotation", rotation);
		SmartDashboard.putNumber("x", x);
		SmartDashboard.putNumber("y", y);
		Robot.pIDDrive.mecanumCartesian(x, y, rotation, gyroAngle);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}

	public boolean inthreshold(double input, double threshold) {
		return (Math.floor(input / threshold) == 0);
	}
    public double joyAddToSetPoint(double joytwist) {
    	//Turn -1 to 1 to -180 to 180
    	joytwist *= 180;
    	double setpoint = Robot.pIDDrive.getSetpoint();
    	setpoint += joytwist;
    	if (setpoint > 180){
    		setpoint -= 180;
    		setpoint = -180 + setpoint;
    	}
    	if (setpoint < -180){
    		setpoint += 180;
    		setpoint = 180 + setpoint;
    	}
    	return setpoint;
    }
}