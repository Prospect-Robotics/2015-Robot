package org.usfirst.frc.team2813.subsystems;



import org.usfirst.frc.team2813.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class IntakePivotRight extends PIDSubsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController intakePivotRight = RobotMap.intakePivotintakePivotRight;
    AnalogPotentiometer intakePotRight = RobotMap.intakePivotintakePotRight;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    double leftIn = .4;
    double rightIn = -.4;
    double leftOut = -.4;
    double rightOut = .4;
    double intakeStop = 0; 
    
    		

    public IntakePivotRight() {
        super("IntakePivotRight", 6, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("IntakePivotRight", "SWAGPID", getPIDController());

    }
    
    public void initDefaultCommand() {
          }
    
    protected double returnPIDInput() {
      
        return intakePotRight.get();
    }
    
   /* protected void usePIDOutput(double outPID1) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        intakePivotLeft.pidWrite(outPID1);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
    }
    */
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
    	
        intakePivotRight.pidWrite(-    output);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
    }
		
}


