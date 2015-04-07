package org.usfirst.frc.team2813.subsystems;

import org.usfirst.frc.team2813.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TrashcanGrabber extends Subsystem {
	Solenoid trashcanGrabberLeft = RobotMap.trashcanGrabberLeft;
	Solenoid trashcanGrabberRight = RobotMap.trashcanGrabberRight;
	Solenoid trashcanGrabberLeftExtend = RobotMap.trashcanGrabberLeftExtend;
	Solenoid trashcanGrabberRightExtend = RobotMap.trashcanGrabberRightExtend;
	DigitalInput backLimitSwitchLeft = RobotMap.backLimitSwitchLeft;
	DigitalInput backLimitSwitchRight = RobotMap.backLimitSwitchRight;

	public void setTrue() {
		trashcanGrabberLeft.set(true);
		trashcanGrabberRight.set(true);
		trashcanGrabberRightExtend.set(true);
		trashcanGrabberLeftExtend.set(false);

	}

	public void setFalse() {
		trashcanGrabberLeft.set(false);
		trashcanGrabberRight.set(false);
		trashcanGrabberLeftExtend.set(false);
		trashcanGrabberRightExtend.set(false);
	}

	public void initDefaultCommand() {

	}

	public boolean isTrue() {
		if (backLimitSwitchLeft.get() && backLimitSwitchRight.get()) {
			return true;
		} else {
			return false;
		}
	}
}
