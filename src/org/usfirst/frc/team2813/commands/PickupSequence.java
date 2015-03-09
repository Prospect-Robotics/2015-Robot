package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PickupSequence extends CommandGroup {

	int counter;

	public PickupSequence() {

		if (Robot.elevator.getEncoderValue() >= ElevatorGround.value - 2
				&& Robot.elevator.getEncoderValue() <= ElevatorGround.value + 2) {
			addSequential(new ElevatorOneTote());
			ReachedSetpoint.checkSetpoint(ElevatorOneTote.value);
		} else {
			addSequential(new RollerIn());
			addSequential(new IntakeLongTote());
			addSequential(new ElevatorDropTote());
			ReachedSetpoint.checkSetpoint(ElevatorDropTote.value);
			addSequential(new ClawOut());
			addSequential(new ElevatorPickup());
			ReachedSetpoint.checkSetpoint(ElevatorPickup.value);
			addSequential(new ClawIn());
			addSequential(new ElevatorGround());
			ReachedSetpoint.checkSetpoint(ElevatorGround.value);
			addSequential(new IntakeWideTote());
			counter = 0;
		}
	}
}
