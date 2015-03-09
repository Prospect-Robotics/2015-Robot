package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeWideTote extends Command {
	
	double leftValue = 0.133;
	double rightValue = 0.376;
	
    public IntakeWideTote() {
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
