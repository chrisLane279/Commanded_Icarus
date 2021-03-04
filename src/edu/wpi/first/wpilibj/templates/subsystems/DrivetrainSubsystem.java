
package edu.wpi.first.wpilibj.templates.subsystems;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;



/**
 *@author Cglan
 * This is the drivetrain subsystem
 */
public class DrivetrainSubsystem extends Subsystem {
   
    
   public static RobotDrive robotdrive;
   
   
   
  public void drivetrainInit(){//initialize the drivetrain
  
  robotdrive = new RobotDrive(RobotMap.LeftDTmotor,RobotMap.RightDTmotor);
  robotdrive.setSafetyEnabled(false);
  robotdrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
  
  }
    
  public void arcadeDrive(double magnitude,double rotation){//drive with arcade controls
  
  robotdrive.setSafetyEnabled(false);
  
  robotdrive.arcadeDrive(magnitude, rotation);
  
  }
  
  public void stop(){//stop the drivetrain
  robotdrive.setSafetyEnabled(false);
       robotdrive.drive(0,0);
  
  }
  
  public void setFans(boolean io){//set the victor fans on/off, they should ALWAYS be on when driving motors
  
  RobotMap.dtFans.set(io);//sets the fans on or off
      
  
  }

    public void initDefaultCommand() {//this subsystem has no default command
        // Set the default command for a subsystem here.
       // setDefaultCommand();
    }
}

