package org.usfirst.frc.team2813.subsystems;

import org.usfirst.frc.team2813.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class IntakePivotLeft extends PIDSubsystem {

    SpeedController intakePivotLeft = RobotMap.intakePivotintakePivotLeft;
    AnalogPotentiometer intakePotLeft = RobotMap.intakePivotintakePotLeft;

    // Initialize your subsystem here
    public IntakePivotLeft() {
    	 super("IntakePivotRight", 6, 0.001, 7.0);
         setAbsoluteTolerance(0.2);
         getPIDController().setContinuous(false);
         LiveWindow.addActuator("IntakePivotLeft", "PIDLAND SWAGCONTROLLER", getPIDController());

    }
    
    public void initDefaultCommand() {

    }
    
    protected double returnPIDInput() {
       return intakePotLeft.get();
    }
    
    protected void usePIDOutput(double output) {
        intakePivotLeft.pidWrite(-output);

    }
}
