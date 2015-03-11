package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Claw extends Command {

    boolean done = false;
    public Claw() {
        requires(Robot.carriage);
    }

    protected void initialize() {
    	if (Robot.carriage.getState()) {
            Robot.carriage.setFalse();
            done = true;
    	}
    	else {
    		Robot.carriage.setTrue();
    		done = true;
    	}
    }

    protected void execute() {
    	
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
