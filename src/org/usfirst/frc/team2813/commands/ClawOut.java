package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClawOut extends Command {

    boolean done = false;
    public ClawOut() {
        requires(Robot.carriage);
    }

    protected void initialize() {
    }

    protected void execute() {
        Robot.carriage.setTrue();
        done = true;
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
        done = false;
    }

    protected void interrupted() {
    }
    
    public static void ClawOut() {
    	Robot.carriage.setTrue();
    }
}