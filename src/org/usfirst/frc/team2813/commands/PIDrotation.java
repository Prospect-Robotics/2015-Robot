package org.usfirst.frc.team2813.commands;

/**
 * Created by Timothy on 2/11/2015.
 */

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2813.robot.Robot;

public class PIDrotation extends Command {
    double x, y;
    double rotation;
    float gyroAngle;
    boolean newSetpoint;

    boolean trigger = false; // placeholder for threshold or button or something

    public PIDrotation() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.pIDDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.pIDDrive.setSetpointtoIMU();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        SmartDashboard.putBoolean("Threshold", inthreshold(Robot.oi.getdriver2().getTwist(), .2));

        //Determine Rotation for Drive, with PID rotation correction
        // if (inthreshold(Robot.oi.joystick2.getTwist(), .2)) {
        if (Robot.oi.getdriver2().getTrigger()) {
            Robot.pIDDrive.disable();
            rotation = Robot.oi.getdriver2().getTwist();
            Robot.pIDDrive.setSetpoint(Robot.nav6.pidGet()); // Set setpoint as current position
        } else {
            Robot.pIDDrive.enable();
            rotation = Robot.pIDDrive.getPIDout();
        }
        //Determine x and y for Drive
        if (Robot.oi.getdriver1().getRawButton(1)) {
            x = Robot.oi.getdriver1().getX() / 2;
            y = Robot.oi.getdriver1().getY() / 4;
        } else {
            x = Robot.oi.getdriver1().getX();
            y = Robot.oi.getdriver1().getY();
        }
        //Determine Gyro Angle for Field Oriented Drive
        gyroAngle = Robot.nav6.getYaw();

        SmartDashboard.putNumber("Setpoint", Robot.pIDDrive.getSetpoint());
        SmartDashboard.putNumber("z", Robot.oi.getdriver2().getTwist());
        SmartDashboard.putNumber("Rotation", rotation);
        SmartDashboard.putNumber("x", x);
        SmartDashboard.putNumber("y", y);
        Robot.pIDDrive.mecanumCartesian(x, y, rotation, gyroAngle);
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

    public boolean inthreshold(double input, double threshold) {
        return (Math.floor(input / threshold) == 0);
    }
}