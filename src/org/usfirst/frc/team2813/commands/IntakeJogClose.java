package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeJogClose extends Command {

	protected void initialize() {
		// TODO Auto-generated method stub

	}

	protected void execute() {
		// TODO Auto-generated method stub
		Robot.intakePivot.pivotIn();
		
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		// TODO Auto-generated method stub
		Robot.intakePivot.pivotStop();
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
