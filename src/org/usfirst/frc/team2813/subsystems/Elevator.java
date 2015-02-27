package org.usfirst.frc.team2813.subsystems;

import org.usfirst.frc.team2813.commands.ElevatorStay;
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

	int counter = 0;

	double leftUp = .8;
	double leftDown = -.8;
	double rightUp = -.8;
	double rightDown = .8;

	double encoder;

	public Elevator() {
		super("Elevator", 1.0, 0.0, 0.0);
		setAbsoluteTolerance(0.2);
		getPIDController().setContinuous(false);
		LiveWindow.addActuator("Elevator", "PIDSubsystem Controller",
				getPIDController());

	}

	public void initDefaultCommand() {
		setDefaultCommand(new ElevatorStay());
	}

	protected double returnPIDInput() {
		return elevatorEncoder.pidGet();
	}

	protected void usePIDOutput(double output) {
		elevatorLeft.pidWrite(output);
	}

	public boolean getMagnet() {
		
		if (RobotMap.elevatorelevatorMagnet.get())
			return false;
		else
			return true;
	}

	public int getCounter() {
		return counter;
	}

	public void counterAddCustom(int add) {
		counter += add;
	}

	public void addCounter() {
		counter++;
	}

	public void minusCounter() {
		counter--;
	}

	public boolean counterMax() {
		if (counter == 4)
			return true;
		else
			return false;
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

	public void triggerElevatorPid() {
		// get encoder insert value into encoder
		elevatorStop();
		// enable the PID
		// set the pid to encoder

	}
	public double returnEncoder(){
		return elevatorEncoder.pidGet();
	}
}
