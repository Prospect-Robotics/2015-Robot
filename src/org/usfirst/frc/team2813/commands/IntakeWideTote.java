package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeWideTote extends Command {
	
	static double leftValue = 0.126;
	static double rightValue = 0.299;
	
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
	
	public static void IntakeWide() {
		Robot.intakePivotIntegrated.intakePivotSet(leftValue, rightValue);
	}
}
