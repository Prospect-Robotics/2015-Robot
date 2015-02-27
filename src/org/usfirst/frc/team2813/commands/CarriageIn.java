package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;
import org.usfirst.frc.team2813.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CarriageIn extends Command {

    boolean done = false;
    public CarriageIn() {
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
}
