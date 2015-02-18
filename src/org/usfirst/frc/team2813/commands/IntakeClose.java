/**
 * 
 */
package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author OLIVIA :) 
 *
 */
public class IntakeClose extends Command {
	
	double leftClose = 0;
	double rightClose = 1.0;

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#initialize()
	 */
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#execute()
	 */
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.intakePivot.pivotIn();
		if (Robot.intakePivot.getPosition() == leftClose){
			Robot.intakePivot.pivotStop();
		}

	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#end()
	 */
	protected void end() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#interrupted()
	 */
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
