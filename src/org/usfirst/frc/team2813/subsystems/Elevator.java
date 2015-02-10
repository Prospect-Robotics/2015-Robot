package org.usfirst.frc.team2813.subsystems;

import org.usfirst.frc.team2813.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Elevator extends PIDSubsystem {
	SpeedController elevatorLeft = RobotMap.elevatorelevatorLeft;
	SpeedController elevatorRight = RobotMap.elevatorelevatorRight;
	Encoder elevatorEncoder = RobotMap.elevatorelevatorEncoder;
	DigitalInput elevatorMagnet = RobotMap.elevatorelevatorMagnet;

	public Elevator() {
		super("Elevator", 1.0, 0.0, 0.0);
		setAbsoluteTolerance(0.2);
		getPIDController().setContinuous(false);
		LiveWindow.addActuator("Elevator", "PIDSubsystem Controller",
				getPIDController());

	}

	public void initDefaultCommand() {

	}

	protected double returnPIDInput() {
		return elevatorEncoder.pidGet();
	}

	protected void usePIDOutput(double output) {
		elevatorLeft.pidWrite(output);
	}
}
