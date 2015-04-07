package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PickupFullStack extends CommandGroup {
    
    public  PickupFullStack() {

    	addSequential(new ElevatorDropTote());
    	addSequential(new ElevatorReachSetpoint());
    	addParallel(new ClawOut());
    	addSequential(new ElevatorPickup());
    	addSequential(new ElevatorReachSetpoint());
    	addSequential(new CommandTimeout(), 0.2);
    	addSequential(new ClawIn());
    	addSequential(new IntakeDropTote());
    	Robot.stack = 0;
    }
}
