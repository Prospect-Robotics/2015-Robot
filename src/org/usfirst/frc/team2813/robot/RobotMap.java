package org.usfirst.frc.team2813.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
<<<<<<< HEAD
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
=======
>>>>>>> origin/master
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class RobotMap {
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static SpeedController elevatorelevatorLeft;
	public static SpeedController elevatorelevatorRight;
	public static Encoder elevatorelevatorEncoder;
	public static DigitalInput elevatorelevatorMagnet;
	public static SpeedController intakePivotintakePivotLeft;
	public static SpeedController intakePivotintakePivotRight;
	public static AnalogPotentiometer intakePivotintakePotLeft;
	public static AnalogPotentiometer intakePivotintakePotRight;
	public static DoubleSolenoid carriagecarriageSolenoid;
	public static SpeedController intakeRollersintakeRollerLeft;
	public static SpeedController intakeRollersintakeRollerRight;
	public static SpeedController pIDDrivefrontLeft;
	public static SpeedController pIDDrivefrontRight;
	public static SpeedController pIDDrivebackLeft;
	public static SpeedController pIDDrivebackRight;
	public static Compressor compressor;
<<<<<<< HEAD
	public static DigitalOutput elevatorGet;
=======
	public static RobotDrive drive;

>>>>>>> origin/master
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public static void init() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
<<<<<<< HEAD
		elevatorelevatorLeft = new Talon(6);
		LiveWindow.addActuator("Elevator", "elevatorLeft",
				(Talon) elevatorelevatorLeft);
=======
		elevatorelevatorLeft = new Talon(2);
		LiveWindow.addActuator("Elevator", "elevatorLeft", (Talon) elevatorelevatorLeft);
>>>>>>> origin/master

		elevatorelevatorRight = new Talon(1);
		LiveWindow.addActuator("Elevator", "elevatorRight", (Talon) elevatorelevatorRight);

		elevatorelevatorEncoder = new Encoder(0, 1, false, EncodingType.k4X);
		LiveWindow.addSensor("Elevator", "elevatorEncoder", elevatorelevatorEncoder);
		elevatorelevatorEncoder.setDistancePerPulse(1.0);
		elevatorelevatorEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
		elevatorelevatorMagnet = new DigitalInput(3);
<<<<<<< HEAD
		LiveWindow.addSensor("Elevator", "elevatorMagnet",
				elevatorelevatorMagnet);
		elevatorGet = new DigitalOutput(4);
		
=======
		LiveWindow.addSensor("Elevator", "elevatorMagnet", elevatorelevatorMagnet);
>>>>>>> origin/master

		intakePivotintakePivotLeft = new Victor(0);
		LiveWindow.addActuator("IntakePivot", "intakePivotLeft", (Victor) intakePivotintakePivotLeft);

		intakePivotintakePivotRight = new Victor(3);
		LiveWindow.addActuator("IntakePivot", "intakePivotRight", (Victor) intakePivotintakePivotRight);

		intakePivotintakePotLeft = new AnalogPotentiometer(0, 1.0, 0.0);
		LiveWindow.addSensor("IntakePivot", "intakePotLeft", intakePivotintakePotLeft);

		intakePivotintakePotRight = new AnalogPotentiometer(1, 1.0, 0.0);
		LiveWindow.addSensor("IntakePivot", "intakePotRight", intakePivotintakePotRight);

		carriagecarriageSolenoid = new DoubleSolenoid(0, 0, 1);
		LiveWindow.addActuator("Carriage", "carriageSolenoid", carriagecarriageSolenoid);

		intakeRollersintakeRollerLeft = new Victor(8);
		LiveWindow.addActuator("IntakeRollers", "intakeRollerLeft", (Victor) intakeRollersintakeRollerLeft);

		intakeRollersintakeRollerRight = new Victor(9);
<<<<<<< HEAD
		LiveWindow.addActuator("IntakeRollers", "intakeRollerRight",
				(Victor) intakeRollersintakeRollerRight);

		pIDDrivefrontLeft = new VictorSP(4);
		LiveWindow.addActuator("PIDDrive", "frontLeft",
				(VictorSP) pIDDrivefrontLeft);

		pIDDrivefrontRight = new Talon(5);
		LiveWindow.addActuator("PIDDrive", "frontRight",
				(Talon) pIDDrivefrontRight);

		pIDDrivebackLeft = new Talon(2);
		LiveWindow
				.addActuator("PIDDrive", "backLeft", (Talon) pIDDrivebackLeft);

		pIDDrivebackRight = new Talon(7);
		LiveWindow.addActuator("PIDDrive", "backRight",
				(Talon) pIDDrivebackRight);
=======
		LiveWindow.addActuator("IntakeRollers", "intakeRollerRight", (Victor) intakeRollersintakeRollerRight);


		boolean isPractice = false;
		if (isPractice){
			pIDDrivefrontLeft = new Talon(4);
			pIDDrivefrontRight = new Talon(5);
			pIDDrivebackLeft = new Talon(6);
			pIDDrivebackRight = new Talon(7);
			LiveWindow.addActuator("PIDDrive", "frontLeft", (Talon) pIDDrivefrontLeft);
			LiveWindow.addActuator("PIDDrive", "frontRight", (Talon) pIDDrivefrontRight);
			LiveWindow.addActuator("PIDDrive", "backLeft", (Talon) pIDDrivebackLeft);
			LiveWindow.addActuator("PIDDrive", "backRight", (Talon) pIDDrivebackRight);
		} else {
			pIDDrivefrontLeft = new VictorSP(4);
			pIDDrivefrontRight = new VictorSP(5);
			pIDDrivebackLeft = new VictorSP(6);
			pIDDrivebackRight = new VictorSP(7);
			LiveWindow.addActuator("PIDDrive", "frontLeft", (VictorSP) pIDDrivefrontLeft);
			LiveWindow.addActuator("PIDDrive", "frontRight", (VictorSP) pIDDrivefrontRight);
			LiveWindow.addActuator("PIDDrive", "backLeft", (VictorSP) pIDDrivebackLeft);
			LiveWindow.addActuator("PIDDrive", "backRight", (VictorSP) pIDDrivebackRight);
		}
		drive = new RobotDrive(pIDDrivefrontLeft, pIDDrivebackLeft, pIDDrivefrontRight, pIDDrivebackRight);
>>>>>>> origin/master

		compressor = new Compressor(0);

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
	}
}
