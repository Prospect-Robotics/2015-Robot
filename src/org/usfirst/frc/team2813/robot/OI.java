package org.usfirst.frc.team2813.robot;

import org.usfirst.frc.team2813.commands.CarriageForward;
import org.usfirst.frc.team2813.commands.CarriageNoMove;
import org.usfirst.frc.team2813.commands.CarriageReverse;
import org.usfirst.frc.team2813.commands.ElevatorIncDown;
import org.usfirst.frc.team2813.commands.ElevatorIncUp;
import org.usfirst.frc.team2813.commands.IntakeClose;
import org.usfirst.frc.team2813.commands.IntakeOpen;
import org.usfirst.frc.team2813.commands.IntakeRolling;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public Joystick driver1;
	public Joystick driver2;
	public Joystick operator;


	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public OI() {
		SmartDashboard.putData("Elevator Up Incremental", new ElevatorIncUp());
		SmartDashboard.putData("Elevator Down Incremental", new ElevatorIncDown());

		
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

		operator = new Joystick(2);

		driver2 = new Joystick(1);

		driver1 = new Joystick(0);

		new JoystickButton(driver1, 6).whenPressed(new ElevatorIncUp());
		new JoystickButton(driver1, 7).whenPressed(new IntakeOpen());
		new JoystickButton(driver1, 8).whenPressed(new IntakeClose());
		new JoystickButton(driver1, 9).whenPressed(new CarriageForward());
		new JoystickButton(driver1, 10).whenPressed(new CarriageReverse());
		new JoystickButton(driver1, 11).whenPressed(new CarriageNoMove());
		new JoystickButton(driver1, 12).whenPressed(new IntakeRolling());
		
		
		

		// SmartDashboard Buttons
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
	}

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
	public Joystick getdriver1() {
		return driver1;

	}

	public Joystick getdriver2() {
		return driver2;
	}

	public Joystick getoperator() {
		return operator;
	}

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

}
