package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CarriageOut extends Command {

    boolean done = false;
    public CarriageOut() {
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
}