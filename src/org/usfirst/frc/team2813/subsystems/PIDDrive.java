package org.usfirst.frc.team2813.subsystems;



import org.usfirst.frc.team2813.commands.PIDrotation;
import org.usfirst.frc.team2813.robot.Robot;
import org.usfirst.frc.team2813.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class PIDDrive extends PIDSubsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController frontLeft = RobotMap.pIDDrivefrontLeft;
    SpeedController frontRight = RobotMap.pIDDrivefrontRight;
    SpeedController backLeft = RobotMap.pIDDrivebackLeft;
    SpeedController backRight = RobotMap.pIDDrivebackRight;
    RobotDrive drive = RobotMap.drive;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private double PIDout;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public PIDDrive() {
        super("Drive", 0.03, 0.001, 0.05);
        getPIDController().setContinuous();
        getPIDController().setInputRange(-180, 180);
        getPIDController().setOutputRange(-1.0, 1.0);
        getPIDController().setAbsoluteTolerance(1);
        LiveWindow.addActuator("RobotDrive", "PIDSubsystem Controller", getPIDController());
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());

        //setDefaultCommand(new FODrive());
        setDefaultCommand(new PIDrotation());
    }
    public double returnPIDInput() {
        return Robot.nav6.pidGet();
    }
    public void usePIDOutput(double output){
        SmartDashboard.putNumber("PIDout", output);
        PIDout = output;
    }
    public double getPIDout(){
        return PIDout;
    }
    public void mecanumCartesian (double x, double y, double rotation, double gyroAngle){
        drive.mecanumDrive_Cartesian(x, y, rotation, gyroAngle);
        SmartDashboard.putNumber("FrontLeft", frontLeft.get());
        SmartDashboard.putNumber("BackLeft", backLeft.get());
        SmartDashboard.putNumber("FrontRight", frontRight.get());
        SmartDashboard.putNumber("BackRight", backRight.get());
    }
    public void mecanumPolar (double magnitude, double direction, double rotation) {
        drive.mecanumDrive_Polar(magnitude, direction, rotation);
    }
    public void setSetpointtoIMU () {
        disable();
        setSetpoint(Robot.nav6.pidGet()); //Set setpoint as current position
        enable();
    }
}
