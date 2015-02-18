package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class IntakeOpen extends Command {
	
	double leftOpen = 1.0;
	double rightOpen = 0;

	protected void initialize() {
		// TODO Auto-generated method stub

	}

	protected void execute() {
		// TODO Auto-generated method stub
		Robot.intakePivot.pivotOut();
		if (Robot.intakePivot.getPosition() == leftOpen){
			Robot.intakePivot.pivotStop();
			
		}
		
		
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		// TODO Auto-generated method stub

	}

	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
