package org.usfirst.frc.team2813.subsystems;

import org.usfirst.frc.team2813.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TrashcanGrabber extends Subsystem {
	Solenoid trashcanGrabberLeft = RobotMap.trashcanGrabberLeft;
	Solenoid trashcanGrabberRight = RobotMap.trashcanGrabberRight;
	
	public void setTrue() {
		trashcanGrabberLeft.set(true);
		trashcanGrabberRight.set(true);

	}
	public void setFalse() {
		trashcanGrabberLeft.set(false);
		trashcanGrabberRight.set(false);
	}

    public void initDefaultCommand() {
       
    }
}

