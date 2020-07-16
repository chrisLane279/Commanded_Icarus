
package edu.wpi.first.wpilibj.templates.subsystems;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;


/**
 *@author Cglan
 * This is the drivetrain subsystem
 */
public class DrivetrainSubsystem extends Subsystem {
   
    
   public  RobotDrive robotdrive;
   
   
   
  public void drivetrainInit(){//initialize the drivetrain
  
  robotdrive = new RobotDrive(RobotMap.LeftDTmotor,RobotMap.RightDTmotor);
  robotdrive.setSafetyEnabled(false);
  robotdrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
  
  
  
  }
    
  public void arcadeDrive(){//drive with arcade controls
  
  robotdrive.setSafetyEnabled(false);
  robotdrive.arcadeDrive(OI.DriveMagnitude,OI.DriveTurn);
  
  
  
  }
  
  public void creep(double speed, double turnSubtractor){//creep forward
      
    
  robotdrive.setSafetyEnabled(false);
  robotdrive.arcadeDrive(speed, OI.DriveTurn-turnSubtractor);
 }   

  
  public void stop(){//stop the drivetrain
  robotdrive.setSafetyEnabled(false);
       robotdrive.drive(0,0);
  
  }

    public void initDefaultCommand() {//this subsystem has no default command
        // Set the default command for a subsystem here.
     //   setDefaultCommand();
    }
}

