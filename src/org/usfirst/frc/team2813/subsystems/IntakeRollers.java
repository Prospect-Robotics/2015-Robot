package org.usfirst.frc.team2813.subsystems;


import org.usfirst.frc.team2813.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class IntakeRollers extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController intakeRollerLeft = RobotMap.intakeRollersintakeRollerLeft;
    SpeedController intakeRollerRight = RobotMap.intakeRollersintakeRollerRight;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    double intakeRollerRightMove = 1.0;
    double intakeRollerLeftMove = -1.0;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void intakeRolling (){
    	intakeRollerLeft.set(intakeRollerLeftMove);
    	intakeRollerRight.set(intakeRollerRightMove);
    	
    	
    }
}

