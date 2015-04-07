package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TrashcanGrabberDown extends Command {

    public TrashcanGrabberDown() {
       requires (Robot.trashcanGrabber);
    }

    protected void initialize() {
    	Robot.trashcanGrabber.setTrue();
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
    
    public static void setTrue() {
    	Robot.trashcanGrabber.setTrue();
    }
}
