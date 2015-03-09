package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeDropTote extends Command {
	
	double leftValue = 0;
	double rightValue = .5;

    public IntakeDropTote() {
    	requires(Robot.intakePivotRight);
		requires(Robot.intakePivotLeft);
	}

	protected void initialize() {
		Robot.intakePivotIntegrated.IntakePivotEnable();
		
	}

	protected void execute() {
		Robot.intakePivotIntegrated.intakePivotSet(leftValue, rightValue);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
