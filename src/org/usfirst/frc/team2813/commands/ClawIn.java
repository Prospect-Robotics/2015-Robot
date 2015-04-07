package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClawIn extends Command {

    boolean done = false;
    public ClawIn() {
        requires(Robot.carriage);
    }

    protected void initialize() {
    }

    protected void execute() {
        Robot.carriage.setFalse();
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
    
    public static void ClawIn() {
    	Robot.carriage.setFalse();
    }
}