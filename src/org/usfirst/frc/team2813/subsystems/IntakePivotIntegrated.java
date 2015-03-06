package org.usfirst.frc.team2813.subsystems;

import org.usfirst.frc.team2813.robot.Robot;

public class IntakePivotIntegrated {

	public void intakePivotSet(double leftValue, double rightValue) {
		Robot.intakePivotLeft.setSetpoint(leftValue);
		Robot.intakePivotRight.setSetpoint(rightValue);
	}

	public void IntakePivotEnable() {
		Robot.intakePivotLeft.enable();
		Robot.intakePivotRight.enable();
	}

	public void IntakePivotDisable() {
		Robot.intakePivotLeft.disable();
		Robot.intakePivotRight.disable();
	}

}
