package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TrashcanGrabberUp extends Command {

    public TrashcanGrabberUp() {
    	requires (Robot.trashcanGrabber);
    }

    protected void initialize() {
    	Robot.trashcanGrabber.setFalse();
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
