package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeLongWide extends Command {
	
	int state = 0;
	boolean done;

	public IntakeLongWide() {
		requires(Robot.intakePivotRight);
		requires(Robot.intakePivotLeft);
	}

	protected void initialize() {
		Robot.intakePivotIntegrated.IntakePivotEnable();
		done = false;
		
	}

	protected void execute() {
		if (state == 0) {
		IntakeLongTote.IntakeLong();
		state = 1;
		done = true;
		}
		else {
			IntakeWideTote.IntakeWide();
		state = 0;
		done = true;
		}
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
