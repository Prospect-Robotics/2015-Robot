package org.usfirst.frc.team2813.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PickupTote extends CommandGroup {
	
    
    public  PickupTote() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm
    	addSequential(new ElevatorOneTote());
    	addSequential(new ElevatorReachSetpoint());
    	addSequential(new ElevatorDropTote());
    	addSequential(new ElevatorReachSetpoint());
    	addParallel(new ClawOut());
    	addSequential(new ElevatorPickup());
    	addSequential(new ElevatorReachSetpoint());
    	addSequential(new CommandTimeout(), 0.2);
    	addSequential(new ClawIn());
    	addSequential(new CommandTimeout(), 0.5);
    	addSequential(new ElevatorOneTote());
    	
    	
    }
}
