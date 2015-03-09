package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeLongTote extends Command {
	
	double leftValue = 0.266;
	double rightValue = 0.236;

	public IntakeLongTote() {
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
