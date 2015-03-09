package org.usfirst.frc.team2813.subsystems;

import org.usfirst.frc.team2813.commands.ElevatorDefault;
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
	DigitalInput elevatorLimitSwitch = RobotMap.elevatorelevatorLimitSwitch;

	int counter = 0;
	
	double maxValue;

	double leftUp = -1.0;
	double leftDown = 1.0;
	double rightUp = 1.0;
	double rightDown = -1.0;
	
	double encoderMax;
	double encoder;

	public Elevator() {
		super("Elevator", .020, 0.015, 0.020);
		setAbsoluteTolerance(0.2);
		getPIDController().setContinuous(false);
		LiveWindow.addActuator("Elevator", "PIDSubsystem Controller",
				getPIDController());

	}

	public void initDefaultCommand() {
		setDefaultCommand(new ElevatorDefault());
	}

	protected double returnPIDInput() {
		return elevatorEncoder.getDistance();
	}

	protected void usePIDOutput(double output) {
		elevatorLeft.pidWrite(-output);
		elevatorRight.pidWrite(output);
	}

	public void elevatorUp() {
		elevatorLeft.set(leftUp);
		elevatorRight.set(rightUp);
	}

	public void elevatorDown() {
		elevatorLeft.set(leftDown);
		elevatorRight.set(rightDown);
	}

	public void elevatorStop() {
		elevatorLeft.set(0.0);
		elevatorRight.set(0.0);
	}

	public void elevatorSet(double speed, String direction) {
		if (direction == "up") {
			elevatorLeft.set(-speed);
			elevatorRight.set(speed);
		}
		if (direction == "down") {
			elevatorLeft.set(speed);
			elevatorRight.set(-speed);
		}
	}
	
	public boolean atBottom() {
		return RobotMap.elevatorelevatorMagnet.get();
	}
	public void triggerElevatorPid() {
		// get encoder insert value into encoder
		elevatorStop();
		// enable the PID
		// set the pid to encoder

	}
	public double returnEncoder(){
		return elevatorEncoder.pidGet();
	}
	
	public void resetEncoder() {
		elevatorEncoder.reset();
	}
	
	public boolean maxHeight() {
		return elevatorLimitSwitch.get();
	}
	
	public void setMaxValue() {
		maxValue = elevatorEncoder.getDistance();
	}
	
	public double getEncoderValue() {
		return elevatorEncoder.getDistance();
	}
	
}
